package org.platypus.erp.data.demo;

import org.platypus.erp.data.demo.json.JsonDemoDataLoader;

import javax.inject.Inject;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class LoadDataDemo {

    @Inject
    private JsonDemoDataLoader jsonDemoDataLoader;

    public void loadJson(DemoDataLoaderBuilder buider){
        jsonDemoDataLoader.load(buider);
    }
}
