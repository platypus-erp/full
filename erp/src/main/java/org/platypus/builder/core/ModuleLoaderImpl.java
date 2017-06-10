package org.platypus.builder.core;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Namable;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.field.tree.FieldTreeApi;
import org.platypus.builder.core.field.tree.FieldTreeBuilder;
import org.platypus.builder.core.model.merger.ModelMergerBuilder;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.model.tree.ModelTreeBuilder;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.moduletree.ModuleTreeBuilder;
import org.platypus.builder.core.records.manager.AstModelHelper;
import org.platypus.builder.core.records.manager.AstRecordRegistry;
import org.platypus.builder.core.records.manager.ModelsFinder;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.records.tree.RecordTree;
import org.platypus.builder.core.records.tree.RecordTreeBuilder;
import org.platypus.builder.core.service.ServiceFinder;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ModuleLoaderImpl implements ModuleLoader {

    private ModuleTree moduleTree;
    private FieldTreeApi treeField;
    private ModelTree modelTree;
    private RecordTree recordTree;
    private ModelsMerged modelsMerged;
    private AstRecordRegistry recordRegistry;
    private TypeSpec.Builder moduleInfoBuilder;
    private Map<String, String> rootRecordSimpleName;
    private Map<ClassName, List<TypeSpec>> newService;
    private final MainArgs mainArgs;
    private Set<AstModel> astModels;
    private Set<PlatypusCompleteModuleInfo> depends;

    public ModuleLoaderImpl(MainArgs mainArgs) {
        this.mainArgs = mainArgs;
        run();
    }

    public void run() {
        parseCurrentProject();
    }

    public void parseCurrentProject() {
        parseProjectModels();
        parseProjectViews();
        parseProjectService();
        loadDependecies();
        addCurrentRecordToRegistry();
    }

    private void parseProjectModels() {
        astModels = ModelsFinder.run(mainArgs.modelsDir);
    }

    private void parseProjectViews() {
    }

    private void parseProjectService() {
        newService = ServiceFinder.run(mainArgs.modelsDir);
    }

    private void addCurrentRecordToRegistry() {
        rootRecordSimpleName = depends.stream()
                .flatMap(p -> p.getModel().values().stream())
                .collect(Collectors.toMap(MetaInfoModel::getClassName, Namable::getName));

        astModels.stream()
                .map(m -> AstModelHelper.convertToRecordCollection(mainArgs.modulename, m))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(m -> recordRegistry.addRecordCollectionFromAst(mainArgs.modulename, m));

        astModels.stream()
                .map(m -> AstModelHelper.convertToRecord(mainArgs.modulename, m))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(m -> recordRegistry.addRecordFromAst(mainArgs.modulename, m));
    }

    private Set<PlatypusCompleteModuleInfo> loadDependecies() {
        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);
        depends = new HashSet<>();
        platypusCompleteModuleInfos.forEach(depends::add);

        System.out.println("depends "+depends);
        recordRegistry = new AstRecordRegistry();
        moduleTree = new ModuleTreeBuilder().build(depends);

        FieldTreeBuilder fieldTreeBuilder = new FieldTreeBuilder();
        depends.forEach(m -> fieldTreeBuilder.addModel(m.techincalName(), m));
        treeField = fieldTreeBuilder.build(moduleTree);

        ModelTreeBuilder modelTreeBuilder = new ModelTreeBuilder();
        depends.forEach(m -> modelTreeBuilder.addModel(m.techincalName(), m));
        modelTree = modelTreeBuilder.build(moduleTree);

        RecordTreeBuilder recordTreeCreator = new RecordTreeBuilder();
        recordTree = recordTreeCreator.build(modelTree);

        depends.forEach(m -> recordRegistry.addModuleFromServiceLoader(m.techincalName(), m));

        modelsMerged = new ModelMergerBuilder().build(treeField);
        return depends;
    }


    @Override
    public PlatypusCompleteModuleInfo getCurrentModule() {
        return null;
    }

    @Override
    public ModuleTree getModuleTree() {
        return moduleTree;
    }

    @Override
    public ModelTree getModelTree() {
        return modelTree;
    }

    @Override
    public ModelsMerged getModelsMerged() {
        return modelsMerged;
    }

    @Override
    public AstRecordRegistry getRecordRegistry() {
        return recordRegistry;
    }
}
