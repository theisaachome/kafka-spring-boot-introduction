package com.isaachome.oms.api.response;

import lombok.extern.log4j.Log4j2;

public record OrderResponse(String orderNumber) {
    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
