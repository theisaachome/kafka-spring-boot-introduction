package com.isaachome.oms.command.action;

import com.isaachome.oms.api.request.DiscountRequest;
import com.isaachome.oms.broker.message.DiscountMessage;
import com.isaachome.oms.broker.producer.DiscountProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountAction {

    @Autowired
    private DiscountProducer discountProducer;
    public void publishToKafka(DiscountRequest data){
         discountProducer.publish(new DiscountMessage(data.discountCode(),data.discountPercentage()));
    }
}
