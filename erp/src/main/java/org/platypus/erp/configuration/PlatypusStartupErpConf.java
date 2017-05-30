package org.platypus.erp.configuration;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Singleton
@Startup
public class PlatypusStartupErpConf {

    @Inject
    private Event<TotoErpConfRegister> registerEvent;

    @PostConstruct
    public void postContruct() {
        TotoErpConfRegister conf = new TotoErpConfRegister();
        registerEvent.fire(conf);
    }

}
