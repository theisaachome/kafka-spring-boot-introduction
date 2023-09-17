package com.isaachome.oms.broker.producer;

import com.isaachome.oms.broker.message.DiscountMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DiscountProducer {
    @Autowired
    private KafkaTemplate<String, DiscountMessage> kafkaTemplate;
    public  void publish(DiscountMessage message){
        kafkaTemplate.send("t-commodity-promotion",message);
    }
}
