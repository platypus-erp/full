package org.platypus.builder.core.records.tree;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/05/17.
 */
public interface RecordTree {

    RecordTreeNode getRecord(String modelName);
    Set<String> getAllRecordName();
    Set<RecordTreeNode> getRecordModel();
}
