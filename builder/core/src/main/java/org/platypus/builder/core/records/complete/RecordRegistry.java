package org.platypus.builder.core.records.complete;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.RecordOfModuleInfo;
import org.platypus.builder.core.model.merger.internal.ModelMerged;
import orp.platypus.impl.module.MetaInfoRecordCollectionImpl;
import orp.platypus.impl.module.MetaInfoRecordImpl;

import javax.lang.model.element.Modifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class RecordRegistry {

    private final Map<String, MetaInfoRecord> records;
    private final Map<String, MetaInfoRecordCollection> recordCollections;
    private final Map<String, ModelMerged> currentModuleModelMerged;

    public RecordRegistry() {
        records = new HashMap<>();
        recordCollections = new HashMap<>();
        currentModuleModelMerged = new HashMap<>();
    }

    public void addModule(String moduleName, RecordOfModuleInfo moduleInfo) {
        records.putAll(moduleInfo.getRecord());
        recordCollections.putAll(moduleInfo.getRecordCollection());
    }

    public void addCurrentModuleModel(ModelMerged metaInfoModel, String className) {
        currentModuleModelMerged.put(className, metaInfoModel);
    }

    public Set<JavaFile.Builder> generateCurrentModuleRecord(String defaultPkgGenerate) {
        currentModuleModelMerged.forEach((key, value) -> records.put(value.getName(),
                new MetaInfoRecordImpl(
                        defaultPkgGenerate + ".records",
                        Utils.toRecordName(key),
                        value.getName()
                )));
        currentModuleModelMerged.forEach((key, value) -> recordCollections.put(value.getName(),
                new MetaInfoRecordCollectionImpl(
                        defaultPkgGenerate + ".records",
                        Utils.toRecordCollectionName(key),
                        value.getName()
                )));
        RecordGenerator recordGenerator = new RecordGenerator();
        currentModuleModelMerged.values().forEach(m -> recordGenerator.generate(m, this));
        return recordGenerator.fileToGenerate.stream()
                .map(TypeSpec.Builder::build)
                .map(t -> JavaFile.builder(defaultPkgGenerate + ".records", t))
                .collect(Collectors.toSet());
    }

    public Map<String, MetaInfoRecord> getRecords() {
        return records;
    }

    public Map<String, MetaInfoRecordCollection> getRecordCollections() {
        return recordCollections;
    }
}
