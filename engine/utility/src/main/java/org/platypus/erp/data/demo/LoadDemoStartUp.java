package org.platypus.erp.data.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import static org.platypus.erp.conf.ErpConf.LOAD_DEMO_DATA;

/**
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Singleton
@Startup
public class LoadDemoStartUp {

    private final Logger LOG = LoggerFactory.getLogger(LoadDemoStartUp.class);

    @Inject
    private LoadDataDemo loadDataDemo;

    @Inject
    private Event<LoadDataDemo> event;

    @PostConstruct
    private void startUp() {
        if (LOAD_DEMO_DATA) {
            LOG.info("------------ Starting Loading Demo Data ------------");
            event.fire(loadDataDemo);
            LOG.info("------------ Finish Loading Demo Data ------------");
        }

    }
}
