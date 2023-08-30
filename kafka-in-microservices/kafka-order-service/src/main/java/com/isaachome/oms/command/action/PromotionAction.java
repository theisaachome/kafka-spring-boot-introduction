package com.isaachome.oms.command.action;

import com.isaachome.oms.api.request.PromotionRequest;
import com.isaachome.oms.broker.message.PromotionMessage;
import com.isaachome.oms.broker.producer.PromotionProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionAction {

    @Autowired
    private PromotionProducer promotionProducer;
    // responsible to publish the message to Kafka
    public void publishKafka(PromotionRequest data){
        promotionProducer.publish(new PromotionMessage(data.promotionCode()));
    }
}
