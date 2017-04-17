package org.platypus.sample.depends;


import org.platypus.api.annotations.ModuleInfo;
import orp.platypus.impl.module.AbstractModule;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
@ModuleInfo(name = "sample_depends", moduleVersion = "1", depends = "base")
public class PlatypusModuleInfo extends AbstractModule{

    public PlatypusModuleInfo() {
        super("Sample Module with all platypus and community depends");
        setLongDesc("long-desc.adoc");
        setLongDesc("short-desc.adoc");
        addModel(new TestModel());
    }
}
