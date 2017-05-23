package org.platypus.impl.module;


import org.platypus.api.module.MetaInfoRecordCollection;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public class MetaInfoRecordCollectionImpl extends MetaInfoRecordImpl implements MetaInfoRecordCollection {
    public MetaInfoRecordCollectionImpl(String pkg, String className, String modelTarget, String modelTargetClassName, String modelTargetPkg) {
        super(pkg, className, modelTarget, modelTargetClassName, modelTargetPkg);
    }
}
