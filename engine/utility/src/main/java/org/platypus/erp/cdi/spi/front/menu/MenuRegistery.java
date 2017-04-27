package org.platypus.erp.cdi.spi.front.menu;

import org.platypus.erp.front.menu.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
enum MenuRegistery {
    I;

    final Map<String, TotoMenu> menu = new HashMap<>();


    public void addMenu(MenuItem menuRootItem) {
        TotoMenu totoMenu = new TotoMenu(menuRootItem);
        if (menuRootItem.getParent() != null) {
            TotoMenu parent = menu.get(menuRootItem.getParent().getMenuId());
            if (parent == null) {
                addMenu(menuRootItem.getParent());
                parent = menu.get(menuRootItem.getParent().getMenuId());
            }
            menu.put(menuRootItem.getMenuId(), totoMenu);
        } else {
            menu.put(menuRootItem.getMenuId(), totoMenu);
        }
    }


    public List<TotoMenu> getRootMenu() {
        return menu.values().stream()
                .filter(m -> m.getParent() == null)
                .sorted((m1, m2) -> Integer.compare(m1.getSequence(), m2.getSequence()))
                .collect(Collectors.toList());
    }

    public List<TotoMenu> getSubMenu() {
        return menu.values().stream()
                .filter(m -> m.getParent() != null)
                .sorted((m1, m2) -> Integer.compare(m1.getSequence(), m2.getSequence()))
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "MenuRegistery{" +
                "menu=" + menu +
                '}';
    }
}
