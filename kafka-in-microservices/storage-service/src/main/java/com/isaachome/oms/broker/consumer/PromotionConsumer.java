package com.isaachome.oms.broker.consumer;

import com.isaachome.oms.broker.message.DiscountMessage;
import com.isaachome.oms.broker.message.PromotionMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "t-commodity-promotion")
@Log4j2
public class PromotionConsumer {

    @KafkaHandler
    public  void  listenPromotion(PromotionMessage message){
        log.info("Processing promotion : {}", message);
    }

    @KafkaHandler
    public  void  listenDiscount(DiscountMessage message){
        log.info("Processing Discount : {} ",message);
    }
}
