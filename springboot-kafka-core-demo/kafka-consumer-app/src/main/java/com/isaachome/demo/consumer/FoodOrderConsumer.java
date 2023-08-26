package com.isaachome.demo.consumer;

import com.isaachome.demo.payload.FoodOrder;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FoodOrderConsumer {

    @KafkaListener(topics = "foodOrderTopic")
    public  void consumer(FoodOrder foodOrder){
         log.info("[Consumer Received : {}]",foodOrder);
    }
}
