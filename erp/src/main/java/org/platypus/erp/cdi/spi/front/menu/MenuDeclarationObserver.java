package org.platypus.erp.cdi.spi.front.menu;

import org.platypus.erp.front.menu.MenuItem;
import org.platypus.erp.front.menu.MenuItemRoot;
import org.platypus.erp.front.menu.SubMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class MenuDeclarationObserver implements Extension {
    private final static List<Class<? extends MenuItem>> notAllowedClass = Arrays.asList(SubMenuItem.class,
            MenuItem.class,
            MenuItemRoot.class,
            TotoMenu.class);
    private final Logger LOG = LoggerFactory.getLogger(MenuDeclarationObserver.class);

    <T extends MenuItem> void processSubMenu(@Observes ProcessAnnotatedType<T> pat) {
        if (!notAllowedClass.contains(pat.getAnnotatedType().getJavaClass())) {
            try {
                T t = pat.getAnnotatedType().getJavaClass().getConstructor().newInstance();
                MenuRegistery.I.addMenu(t);
                LOG.info("MenuItem[{}] Icon[{}]", t.getLabel(), t.getPathIcon());
            } catch (Exception e) {
                LOG.error("Can't create instance of [" + pat.getAnnotatedType().getJavaClass() + "].", e);
            }
        }
    }

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
        LOG.info("{}", MenuRegistery.I.toString());

    }
}