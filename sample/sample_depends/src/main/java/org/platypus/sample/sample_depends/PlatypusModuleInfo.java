package org.platypus.sample.sample_depends;


import org.platypus.api.annotations.ModuleInfo;
import org.platypus.builder.core.AbstractModule;
import org.platypus.sample.sample_depends.models.TestModel;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
@ModuleInfo(name = "org/platypus/sample/sample_depends/models", moduleVersion = "1", depends = "base")
public class PlatypusModuleInfo extends AbstractModule{

    public PlatypusModuleInfo() {
        super("Sample Module with all platypus and community depends");
        setLongDesc("long-desc.adoc");
        setShortDesc("short-desc.adoc");
        addModel(new TestModel());
    }
}
