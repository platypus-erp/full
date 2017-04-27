package org.platypus.erp.notification.demo;

import org.platypus.erp.data.demo.LoadDataDemo;
import org.platypus.erp.notification.Notification;

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
public class NotificationDemoData {

    public void loadDemoData(@Observes LoadDataDemo payLoad){
        payLoad.loadJson(
                createStream(NotificationDemoData.class, "demo-data.json")
                .convertToCollectionOfEntity(Notification.class));
    }
}
