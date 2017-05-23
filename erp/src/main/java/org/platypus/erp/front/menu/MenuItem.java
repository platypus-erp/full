package org.platypus.erp.front.menu;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@XmlRootElement
public interface MenuItem {

    String getMenuId();
    String getLabel();
    MenuItem getParent();
    String getPathIcon();
    String getAction();
    int getSequence();
    String getTarget();
    default String getMiniDesc(){
        return "";
    }

}
