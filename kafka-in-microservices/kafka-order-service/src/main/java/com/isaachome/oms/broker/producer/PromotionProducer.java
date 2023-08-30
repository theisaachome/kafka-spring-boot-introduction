package com.isaachome.oms.broker.producer;

import com.isaachome.oms.broker.message.PromotionMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PromotionProducer {
    @Autowired
    private KafkaTemplate<String, PromotionMessage> kafkaTemplate;
    public  void  publish(PromotionMessage message){
        kafkaTemplate.send("t-commodity-promotion",message).whenComplete(
                (result,err)->{
                    if(result !=null){
                        log.info("Send result success for message {}", result.getProducerRecord().value());
                    }else {
                        log.warn("Error publishing {}, because {}", message, err.getMessage());
                    }
                }
        );
    }
}
