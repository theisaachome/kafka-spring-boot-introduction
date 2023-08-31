package com.isaachome.oms.command.service;

import com.isaachome.oms.api.request.DiscountRequest;
import com.isaachome.oms.command.action.DiscountAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountAction discountAction;
    public  void  createDiscount(DiscountRequest data){
        // action method call.
        discountAction.publishToKafka(data);
    }
}
