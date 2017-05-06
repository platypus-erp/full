package orp.platypus.impl.module;


import org.platypus.api.module.MetaInfoRecord;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public class MetaInfoRecordImpl implements MetaInfoRecord {
    private final String pkg;
    private final String className;
    private final String modelTarget;
    private final String modelTargetClassName;
    private final String modelTargetPkg;

    public MetaInfoRecordImpl(String pkg, String className, String modelTarget, String modelTargetClassName, String modelTargetPkg) {
        this.pkg = pkg;
        this.className = className;
        this.modelTarget = modelTarget;
        this.modelTargetClassName = modelTargetClassName;
        this.modelTargetPkg = modelTargetPkg;
    }

    @Override
    public String getModelTargetClassName() {
        return modelTargetClassName;
    }

    @Override
    public String getModelTargetPkg() {
        return modelTargetPkg;
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
