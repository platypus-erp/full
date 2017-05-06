package org.platypus.builder.core;

import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
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
import org.platypus.builder.core.records.manager.AstRecordRegistry;
import org.platypus.builder.core.records.manager.RecordFinder;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.records.tree.RecordTree;
import org.platypus.builder.core.records.tree.RecordTreeBuilder;
import orp.platypus.impl.module.MetaInfoRecordCollectionImpl;
import orp.platypus.impl.module.MetaInfoRecordImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class ModuleLoaderImpl implements ModuleLoader{

    private ModuleTree moduleTree;
    private FieldTreeApi treeField;
    private ModelTree modelTree;
    private RecordTree recordTree;
    private ModelsMerged modelsMerged;
    private AstRecordRegistry recordRegistry;
    private TypeSpec.Builder moduleInfoBuilder;
    private Map<String, String> rootRecordSimpleName;
    private final MainArgs mainArgs;
    private Set<AstModel> astModels;
    private Set<PlatypusCompleteModuleInfo> depends;

    public ModuleLoaderImpl(MainArgs mainArgs) {
        this.mainArgs = mainArgs;
    }

    public void parseCurrentProject(){

    }

    private void parseProjectModels(){
        astModels = RecordFinder.run(mainArgs.getSrcDirs());
    }
    private void parseProjectViews(){
    }

    private void addCurrentRecordToRegistry() {
        rootRecordSimpleName = depends.stream()
                .flatMap(p -> p.getModel().values().stream())
                .collect(Collectors.toMap(MetaInfoModel::getClassName, Namable::getName));
        for (AstModel astModel : astModels) {
            if (astModel.isRootModel()) {
                String recordClassName = StringUtils.capitalize(mainArgs.getModulename())
                        + StringUtils.capitalize(astModel.getClassName())
                        + "RecordCollection";
                MetaInfoRecordCollectionImpl rcImpl = new MetaInfoRecordCollectionImpl(
                        astModel.getPkg() + ".generated.records",
                        recordClassName,
                        astModel.getModelName(),
                        astModel.getClassName(),
                        astModel.getPkg()
                );
                recordRegistry.addRecordCollection(mainArgs.getModulename(), rcImpl);
            }
            String recordClassName = StringUtils.capitalize(mainArgs.getModulename())
                    + StringUtils.capitalize(astModel.getClassName())
                    + "Record";
            MetaInfoRecordImpl i = new MetaInfoRecordImpl(
                    astModel.getPkg() + ".generated.records",
                    recordClassName,
                    astModel.getModelName(),
                    astModel.getClassName(),
                    astModel.getPkg()
            );
            recordRegistry.addRecord(mainArgs.getModulename(), i);
        }
    }

    private Set<PlatypusCompleteModuleInfo> loadDependecies() {
        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);
        Set<PlatypusCompleteModuleInfo> depends = new HashSet<>();
        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
                depends.add(m);
        }
        recordRegistry = new AstRecordRegistry();
        if (depends.isEmpty()) {
            moduleTree = ModuleTreeBuilder.emptyTree();
            treeField = FieldTreeBuilder.emptyTree();
            modelTree = ModelTreeBuilder.emptyTree();
            recordTree = RecordTreeBuilder.emptyTree();
            modelsMerged = ModelMergerBuilder.emptyTree();
        } else {
            ModuleTreeBuilder moduleTreeBuilder = new ModuleTreeBuilder();
            moduleTree = moduleTreeBuilder.build(depends);

            FieldTreeBuilder fieldTreeBuilder = new FieldTreeBuilder();
            depends.forEach(m -> fieldTreeBuilder.addModel(m.techincalName(), m));
            treeField = fieldTreeBuilder.build(moduleTree);

            ModelTreeBuilder modelTreeBuilder = new ModelTreeBuilder();
            depends.forEach(m -> modelTreeBuilder.addModel(m.techincalName(), m));
            modelTree = modelTreeBuilder.build(moduleTree);

            RecordTreeBuilder recordTreeCreator = new RecordTreeBuilder();
            recordTree = recordTreeCreator.build(modelTree);

            depends.forEach(m -> recordRegistry.addModule(m.techincalName(), m));

            modelsMerged = new ModelMergerBuilder().build(treeField);
        }
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
