package orp.platypus.impl.module;

import org.platypus.api.module.MetaInfoRecordCollection;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public class MetaInfoRecordCollectionImpl implements MetaInfoRecordCollection{
    private final String pkg;
    private final String className;
    private final String modelTarget;

    public MetaInfoRecordCollectionImpl(String pkg, String className, String modelTarget) {
        this.pkg = pkg;
        this.className = className;
        this.modelTarget = modelTarget;
    }

    @Override
    public String getPkg() {
        return pkg;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String getModelTarget() {
        return modelTarget;
    }
}
