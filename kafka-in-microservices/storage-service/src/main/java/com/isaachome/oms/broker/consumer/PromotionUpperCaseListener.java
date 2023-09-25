package com.isaachome.oms.broker.consumer;

import com.isaachome.oms.broker.message.PromotionMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PromotionUpperCaseListener {

    @KafkaListener(topics = "t-commodity-promotion-uppercase")
    public  void  listen(PromotionMessage message){
        log.info("Processing promotion :{}",message.toString());
    }
}
