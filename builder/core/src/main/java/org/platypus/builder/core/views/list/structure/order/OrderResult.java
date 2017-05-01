package org.platypus.builder.core.views.list.structure.order;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class OrderResult {

    private final int order;
    private final String error;

    public static OrderResult ok(int order){
        return new OrderResult(order, null);
    }

    public static OrderResult error(String msg){
        return new OrderResult(0, msg);
    }

    private OrderResult(int order, String error) {
        this.order = order;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public int getOrder() {

        return order;
    }
}
