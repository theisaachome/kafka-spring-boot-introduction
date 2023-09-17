package com.isaachome.oms.api.request;

import java.util.List;

public record OrderRequest(String orderLocation, String creditCardNumber, List<OrderItemRequest> items) {
    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLocation='" + orderLocation + '\'' +
                ", creditNumber='" + creditCardNumber + '\'' +
                ", items=" + items +
                '}';
    }
}
