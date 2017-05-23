package org.platypus.erp.cdi.spi.front.menu;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;
import static org.platypus.erp.cdi.spi.front.menu.MenuRegistery.I;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@SessionScoped
public class MenuDelivrer implements Serializable{

    List<TotoMenu> roots;
    Map<String, List<TotoMenu>> subMenu;

    @PostConstruct
    public void postConstruct(){
        roots = unmodifiableList(I.getRootMenu().stream()
//                .filter() when security enable
                .collect(Collectors.toList()));

        subMenu = unmodifiableMap(MenuRegistery.I.getSubMenu().stream()
                .collect(Collectors.groupingBy(item -> item.getParent().getMenuId())));
    }

    public List<TotoMenu> getRoots() {
        return roots;
    }

    public List<TotoMenu> getSubRoots(String rootKey) {
        return subMenu.get(rootKey);
    }
}
