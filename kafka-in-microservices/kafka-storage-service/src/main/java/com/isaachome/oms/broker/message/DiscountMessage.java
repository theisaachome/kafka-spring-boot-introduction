package com.isaachome.oms.broker.message;

public record DiscountMessage(String discountCode,int discountPercentage) {
    @Override
    public String toString() {
        return "DiscountMessage [discountCode : " + discountCode + ", discountPercentage : " + discountPercentage + "]";
    }
}
