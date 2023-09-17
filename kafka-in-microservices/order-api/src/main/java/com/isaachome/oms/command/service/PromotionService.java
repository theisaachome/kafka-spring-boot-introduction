package com.isaachome.oms.command.service;

import com.isaachome.oms.api.request.PromotionRequest;
import com.isaachome.oms.command.action.PromotionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionAction promotionAction;

    public  void  createPromotion(PromotionRequest data){
        promotionAction.publishKafka(data);
    }
}
