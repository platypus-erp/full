package org.platypus.erp.module.base;


import org.platypus.api.annotations.ModuleInfo;
import org.platypus.builder.core.AbstractModule;
import org.platypus.erp.module.base.models.Partner;
import org.platypus.erp.module.base.models.Company;
import org.platypus.erp.module.base.models.Group;
import org.platypus.erp.module.base.models.User;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
@ModuleInfo(name = "base", moduleVersion = "1")
public class PlatypusModuleInfo extends AbstractModule{

    public PlatypusModuleInfo() {
        super("Sample Module with all platypus and community depends");
//        setLongDesc("long-desc.adoc");
//        setShortDesc("short-desc.adoc");
        addModel(new User());
        addModel(new Group());
        addModel(new Partner());
        addModel(new Company());
    }
}
