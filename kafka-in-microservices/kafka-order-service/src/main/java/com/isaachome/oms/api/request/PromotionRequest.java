package com.isaachome.oms.api.request;

public record PromotionRequest (String promotionCode){
    @Override
    public String toString() {
        return "PromotionRequest [promotionCode=" + promotionCode + "]";
    }

}
