package org.platypus.builder.core.records.quick;

import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.RecordOfModuleInfo;
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.core.records.quick.astvisitor.AstModel;
import org.platypus.builder.core.records.quick.astvisitor.Visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public class AstRecordRegistry {

    private final Map<String, MetaInfoRecord> records;
    private final Map<String, MetaInfoRecordCollection> recordCollections;
    private final Map<String, Visitor> currentModuleModelMerged;

    public AstRecordRegistry() {
        records = new HashMap<>();
        recordCollections = new HashMap<>();
        currentModuleModelMerged = new HashMap<>();
    }

    public void addModule(String moduleName, RecordOfModuleInfo moduleInfo) {
        records.putAll(moduleInfo.getRecord());
        recordCollections.putAll(moduleInfo.getRecordCollection());
    }

    public void addRecord(String moduleName, MetaInfoRecord metaInfoRecord){
        records.put(metaInfoRecord.getModelTargetClassName(), metaInfoRecord);
    }
    public void addRecordCollection(String moduleName, MetaInfoRecordCollection metaInfoRecord){
        recordCollections.put(metaInfoRecord.getModelTargetClassName(), metaInfoRecord);
    }

    public MetaInfoRecord getMetaInfoTargetByClassName(String classNameTarget) {
        return records.get(classNameTarget);
    }

    public MetaInfoRecordCollection getMetaInfoCollectionTargetByClassName(String classNameTarget) {
        return recordCollections.get(classNameTarget);
    }

    public MetaInfoRecord getMetaInfoTargetByClassName(AstModel classNameTarget) {
        return records.get(classNameTarget.getClassName());
    }

    public MetaInfoRecordCollection getMetaInfoCollectionTargetByClassName(AstModel classNameTarget) {
        return recordCollections.get(classNameTarget.getClassName());
    }
}
