package org.platypus.builder.core.service.tree;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/05/17.
 */
public interface BusinessTree {

    BusinessTreeNode getMethod(String methodName);
    Set<String> getAllRecordName();
    Set<BusinessTreeNode> getRecordModel();
}
