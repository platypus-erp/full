package org.platypus.erp.core.partner.demo;

import org.platypus.erp.core.partner.Partner;
import org.platypus.erp.data.demo.LoadDataDemo;

import javax.enterprise.event.Observes;

import static org.platypus.erp.data.demo.DemoDataLoaderBuilder.createStream;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class DemoLoader {

    public void loadDemoData(@Observes LoadDataDemo payLoad){
        payLoad.loadJson(
                createStream(DemoLoader.class, "demo-data.json")
                .convertToCollectionOfEntity(Partner.class));
    }
}
