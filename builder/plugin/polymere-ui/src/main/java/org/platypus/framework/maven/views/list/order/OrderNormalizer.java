package org.platypus.framework.maven.views.list.order;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OrderNormalizer {

    private int order = 1;

    public int getOrder(){
        int result = order;
        order ++;
        return result;
    }
}
