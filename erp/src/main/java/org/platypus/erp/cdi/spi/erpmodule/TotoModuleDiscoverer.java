package org.platypus.erp.cdi.spi.erpmodule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.WithAnnotations;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoModuleDiscoverer implements Extension {

    private final Logger LOG = LoggerFactory.getLogger(TotoModuleDiscoverer.class);

    <T extends TotoModuleDec> void processAnnotatedType(@Observes @WithAnnotations(TotoModule.class) ProcessAnnotatedType<T> pat) {
        LOG.info("Toto Module detected[{}] with methodName [{}]",
                pat.getAnnotatedType().getJavaClass().getName(),
                pat.getAnnotatedType().getAnnotation(TotoModule.class).name());
    }
}
