package org.platypus.api.module;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public interface RecordOfModuleInfo {

    Map<String, MetaInfoRecordCollection> getRecordCollection();

    Map<String, MetaInfoRecord> getRecord();
}
