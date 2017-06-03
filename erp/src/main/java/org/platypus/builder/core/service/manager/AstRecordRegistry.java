package org.platypus.builder.core.service.manager;

import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.RecordOfModuleInfo;
import org.platypus.builder.core.service.manager.astvisitor.AstService;
import org.platypus.builder.core.service.manager.astvisitor.ServiceVisitor;

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
    private final Map<String, MetaInfoRecord> recordsByName;
    private final Map<String, MetaInfoRecordCollection> recordCollectionsByName;
    private final Map<String, ServiceVisitor> currentModuleModelMerged;

    public AstRecordRegistry() {
        records = new HashMap<>();
        recordCollections = new HashMap<>();
        currentModuleModelMerged = new HashMap<>();
        recordsByName = new HashMap<>();
        recordCollectionsByName = new HashMap<>();
    }

    public void addModuleFromServiceLoader(String moduleName, RecordOfModuleInfo moduleInfo) {
        moduleInfo.getRecord().forEach((k,v) -> recordsByName.put(v.getModelTarget(), v));
        moduleInfo.getRecordCollection().forEach((k,v) -> recordCollectionsByName.put(v.getModelTarget(), v));
    }

    public void addRecordFromAst(String moduleName, MetaInfoRecord metaInfoRecord){
        records.put(metaInfoRecord.getModelTargetClassName(), metaInfoRecord);
    }
    public void addRecordCollectionFromAst(String moduleName, MetaInfoRecordCollection metaInfoRecord){
        recordCollections.put(metaInfoRecord.getModelTargetClassName(), metaInfoRecord);
    }

    public MetaInfoRecord getMetaInfoTargetByClassName(String classNameTarget) {
        return records.get(classNameTarget);
    }

    public MetaInfoRecordCollection getMetaInfoCollectionTargetByClassName(String classNameTarget) {
        return recordCollections.get(classNameTarget);
    }

    public MetaInfoRecord getMetaInfoTargetByTargetName(String classNameTarget) {
        return recordsByName.get(classNameTarget);
    }

    public MetaInfoRecordCollection getMetaInfoCollectionTargetByTargetName(String classNameTarget) {
        return recordCollectionsByName.get(classNameTarget);
    }

    public MetaInfoRecord getMetaInfoTargetByClassName(AstService classNameTarget) {
        return records.get(classNameTarget.getClassName());
    }

    public MetaInfoRecordCollection getMetaInfoCollectionTargetByClassName(AstService classNameTarget) {
        return recordCollections.get(classNameTarget.getClassName());
    }

    @Override
    public String toString() {
        return "AstRecordRegistry{" +
                "records=" + records +
                ",\n recordCollections=" + recordCollections +
                ",\n recordsByName=" + recordsByName +
                ",\n recordCollectionsByName=" + recordCollectionsByName +
                ",\n currentModuleModelMerged=" + currentModuleModelMerged +
                '}';
    }
}
