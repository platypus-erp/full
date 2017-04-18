package org.platypus.builder.core.plugin.record;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.RecordOfModuleInfo;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import orp.platypus.impl.module.MetaInfoRecordImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
