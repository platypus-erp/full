package org.platypus.erp.cdi.spi.front.menu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.platypus.erp.front.menu.MenuItem;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoMenu implements MenuItem {
    private String menuId;
    private String label;
    @JsonIgnoreProperties
    private MenuItem parent;
    private String pathIcon;
    private String action;
    private int sequence;
    private String miniDesc;
    private String target;

    public TotoMenu(MenuItem menuItem) {
        this.menuId = menuItem.getMenuId();
        this.label = menuItem.getLabel();
        this.parent = menuItem.getParent();
        this.pathIcon = menuItem.getPathIcon();
        this.action = menuItem.getAction();
        this.sequence = menuItem.getSequence();
        this.miniDesc = menuItem.getMiniDesc();
        this.target = menuItem.getTarget();
    }

    @Override
    public String getMenuId() {
        return menuId;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public MenuItem getParent() {
        return parent;
    }

    @Override
    public String getPathIcon() {
        return pathIcon;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public int getSequence() {
        return sequence;
    }

    @Override
    public String getMiniDesc() {
        return miniDesc;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "TotoMenu{" +
                "menuId='" + menuId + '\'' +
                ", label='" + label + '\'' +
                ", parent=" + parent +
                ", pathIcon='" + pathIcon + '\'' +
                ", action='" + action + '\'' +
                ", sequence=" + sequence +
                ", miniDesc='" + miniDesc + '\'' +
                '}';
    }
}
