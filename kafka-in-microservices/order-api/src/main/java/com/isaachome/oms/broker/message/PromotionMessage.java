package com.isaachome.oms.broker.message;

public record PromotionMessage (String promotionCode){
    @Override
    public String toString() {
        return "PromotionMessage [promotionCode=" + promotionCode + "]";
    }
}
