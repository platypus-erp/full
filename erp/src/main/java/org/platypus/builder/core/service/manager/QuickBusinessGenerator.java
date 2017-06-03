package org.platypus.builder.core.service.manager;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Namable;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.service.manager.astvisitor.AstService;
import org.platypus.builder.core.service.tree.BusinessTree;
import org.platypus.builder.core.service.tree.RecordTreeBuilder;
import org.platypus.builder.core.field.tree.FieldTreeApi;
import org.platypus.builder.core.field.tree.FieldTreeBuilder;
import org.platypus.builder.core.model.merger.ModelMergerBuilder;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.model.tree.ModelTreeBuilder;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.moduletree.ModuleTreeBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
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
public class QuickBusinessGenerator {

    private PlatypusCompleteModuleInfo currentModule;
    private ModuleTree moduleTree;
    private FieldTreeApi treeField;
    private ModelTree modelTree;
    private BusinessTree recordTree;
    private ModelsMerged modelsMerged;
    private AstRecordRegistry recordRegistry;
    private AstRecordRegistry currentModuleRegistry;
    private TypeSpec.Builder moduleInfoBuilder;
    private Map<String, String> rootRecordSimpleName;
    private final Path projectDir;
    private final String group;
    private final Set<AstService> astModels;
    private final String currentModuleName;

    public QuickBusinessGenerator(Path dirToGenerate, String group, String name, Set<AstService> astModels) {
        this.projectDir = dirToGenerate;
        this.group = group;
        this.currentModuleName = name;
        this.astModels = astModels;
        currentModuleRegistry = new AstRecordRegistry();
    }

    public void generateRecord() {
        Set<PlatypusCompleteModuleInfo> depends = init(currentModuleName);
        rootRecordSimpleName = depends.stream()
                .flatMap(p -> p.getModel().values().stream())
                .collect(Collectors.toMap(MetaInfoModel::getClassName, Namable::getName));
        AstRecordGenerator astRecordGenerator = new AstRecordGenerator(currentModuleName);
        for (AstService astModel : astModels) {
            Optional<MetaInfoRecordCollection> rc = AstModelHelper.convertToRecordCollection(currentModuleName, astModel);
            Optional<MetaInfoRecord> r = AstModelHelper.convertToRecord(currentModuleName, astModel);
            rc.ifPresent(m -> {
                        currentModuleRegistry.addRecordCollectionFromAst(currentModuleName, m);
                        recordRegistry.addRecordCollectionFromAst(currentModuleName, m);
                    }
            );
            r.ifPresent(m -> {
                        currentModuleRegistry.addRecordFromAst(currentModuleName, m);
                        recordRegistry.addRecordFromAst(currentModuleName, m);
                    }
            );
        }
        astModels.forEach(ast -> astRecordGenerator.generateRootRecord(ast, recordRegistry));
        for (JavaFile.Builder files : astRecordGenerator.fileToGenerate.stream()
                .map(AstRecordGenerator.FileToGenerate::toJavaFile)
                .collect(Collectors.toSet())) {
            createFile(files);
        }
        createFile(JavaFile.builder(currentModuleName, astRecordGenerator.poolBuilder.build()));
    }

    private void createFile(JavaFile.Builder files) {
        try {
            files.indent("   ").build().writeTo(projectDir.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<PlatypusCompleteModuleInfo> init(String currentModuleName) {
        ServiceLoader<PlatypusCompleteModuleInfo> platypusCompleteModuleInfos = ServiceLoader.load(PlatypusCompleteModuleInfo.class);
        Set<PlatypusCompleteModuleInfo> depends = new HashSet<>();
        for (PlatypusCompleteModuleInfo m : platypusCompleteModuleInfos) {
            if (currentModuleName.equals(m.techincalName())) {
                System.out.println("current module is : " + currentModuleName);
                currentModule = m;
            } else {
                depends.add(m);
            }
        }
//        if (currentModule == null) {
//            throw new IllegalArgumentException("Module[" + currentModuleName + "] not found");
//        }
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

            depends.forEach(m -> recordRegistry.addModuleFromServiceLoader(m.techincalName(), m));

            modelsMerged = new ModelMergerBuilder().build(treeField);
        }
        return depends;
    }
}
