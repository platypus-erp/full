package org.platypus.builder.core.service.manager;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.Namable;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.records.manager.AstModelHelper;
import org.platypus.builder.core.records.manager.AstRecordGenerator;
import org.platypus.builder.core.records.manager.astvisitor.AstModel;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 15/06/17.
 */
public class ServiceGenerator {

    public static void generateRecord(MainArgs args, Map<ClassName, TypeSpec.Builder> g) {
        for(Map.Entry<ClassName, TypeSpec.Builder> e : g.entrySet()){
            createFile(args, JavaFile.builder(args.defaultPkg + ".services", e.getValue().build()));

        }
    }

    private static void createFile(MainArgs args, JavaFile.Builder files) {
        try {
            files.indent("   ").build().writeTo(MainArgs.toPathToGenerate(args.projectDirStr).toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
