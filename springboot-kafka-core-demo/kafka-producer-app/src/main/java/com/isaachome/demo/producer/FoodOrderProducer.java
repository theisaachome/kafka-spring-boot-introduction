package com.isaachome.demo.producer;

import com.isaachome.demo.payload.FoodOrder;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FoodOrderProducer {
    private  final KafkaTemplate<String, FoodOrder> kafkaTemplate;

    public FoodOrderProducer(KafkaTemplate<String, FoodOrder> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void sendMessage(FoodOrder data){
        Message<FoodOrder> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"foodOrderTopic")
                .build();
        log.info("[FoodOrder sending Message : {}]",message);
        kafkaTemplate.send(message);
    }
}
