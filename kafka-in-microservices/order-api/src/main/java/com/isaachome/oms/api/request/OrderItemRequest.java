package com.isaachome.oms.api.request;

public record OrderItemRequest(String itemName,int price,int quantity) {
    @Override
    public String toString() {
        return "OrderItemRequest[" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ']';
    }
}
