package org.platypus.builder;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.annotations.ModuleInfo;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.AbstractModule;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.records.manager.AstModelHelper;
import org.platypus.builder.core.records.manager.ModelsFinder;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;
import org.platypus.builder.core.views.ViewsFinder;

import javax.lang.model.element.Modifier;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class ModuleInfoBuilder {
    public static void main(String[] args) {
        MainArgs mainArgs = new MainArgs(args);
        Set<AstModel> models = ModelsFinder.run(mainArgs.modelsDir);
        Set<MetaInfoRecordCollection> metaInfoRecordCollections = models.stream()
                .map(m -> AstModelHelper.convertToRecordCollection(mainArgs.modulename, m))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        Set<MetaInfoRecord> metaInfoRecord = models.stream()
                .map(m -> AstModelHelper.convertToRecord(mainArgs.modulename, m))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        Set<Path> views = ViewsFinder.find(mainArgs.projectDirStr, mainArgs.modulename);

        String mouleInfoClassName = StringUtils.capitalize(mainArgs.modulename) + "ModuleInfo";
        ClassName abstractModule = ClassName.get(AbstractModule.class);
        TypeSpec.Builder moduleInfo = TypeSpec.classBuilder(mouleInfoClassName)
                .addModifiers(Modifier.PUBLIC);
        moduleInfo.superclass(abstractModule);

        AnnotationSpec.Builder moduleInfoAnnotation = AnnotationSpec.builder(ModuleInfo.class);
        moduleInfoAnnotation.addMember("methodName", "$S", mainArgs.modulename);
        moduleInfoAnnotation.addMember("moduleVersion", "$S", mainArgs.moduleVersion);
        if (mainArgs.depends.length > 0) {
            String format = StringUtils.repeat("$S", ", ", mainArgs.depends.length);
            moduleInfoAnnotation.addMember("depends", "{" + format + "}", (Object[]) mainArgs.depends);
        }
        moduleInfo.addAnnotation(moduleInfoAnnotation.build());

        MethodSpec.Builder construc = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC);
        construc.addCode("super($S);\n", mainArgs.quickDesc);
        models.stream()
                .map(astModel -> ClassName.get(astModel.getPkg(), astModel.getClassName()))
                .forEach(c -> construc.addCode("addModel($T.class);\n", c));

        metaInfoRecord.stream()
                .map(astModel -> ClassName.get(astModel.getPkg(), astModel.getClassName()))
                .forEach(c -> construc.addCode("addRecord($T.class);\n", c));

        metaInfoRecordCollections.stream()
                .map(astModel -> ClassName.get(astModel.getPkg(), astModel.getClassName()))
                .forEach(c -> construc.addCode("addRecordCollection($T.class);\n", c));

        views.forEach(c -> construc.addCode("addView($S);\n", c));

        moduleInfo.addMethod(construc.build());
        JavaFile file = JavaFile.builder(mainArgs.modulename, moduleInfo.build())
                .indent("    ")
                .build();
        try {
            file.writeTo(MainArgs.toPathToMainJava(mainArgs.projectDirStr).toFile());
            Path pathservices = MainArgs.toPathToGenerate(mainArgs.projectDirStr);
            if (!Files.exists(pathservices)) {
                Files.createDirectories(pathservices);
            }
            List<String> lines = Collections.singletonList(file.packageName + "." + file.typeSpec.name);
            Files.write(pathservices.resolve(PlatypusCompleteModuleInfo.class.getCanonicalName())
                    , lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
