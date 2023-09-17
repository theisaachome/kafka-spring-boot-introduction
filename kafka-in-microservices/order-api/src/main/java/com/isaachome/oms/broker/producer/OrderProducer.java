package com.isaachome.oms.broker.producer;
import com.isaachome.oms.broker.message.OrderMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, OrderMessage> kafkaTemplate;
    public  void sendMessage(OrderMessage message){
        kafkaTemplate.send(buildProducerRecord(message))
                .whenComplete((result,ex)->{
                    if(ex==null){
                        log.info("Order {}, item {} published successfully", message.orderNumber(),
                                message.itemName());
                    }else {
                        log.warn("Order {}, item {} failed to publish because {}", message.orderNumber(),
                                message.itemName(), ex.getMessage());
                    }
                });
//        log.info("Just a dummy message for order {}, item {} published successfully", message.orderNumber(),
//                message.itemName());

    }

    private ProducerRecord<String,OrderMessage> buildProducerRecord(OrderMessage message){
        var surpriseBonus = StringUtils.startsWithIgnoreCase(message.orderLocation(), "A") ? 25 : 15;
        var headers = new ArrayList<Header>();
        var surpriseBonusHeader = new RecordHeader("surpriseBonus", Integer.toString(surpriseBonus).getBytes());
        headers.add(surpriseBonusHeader);
        return  new ProducerRecord<String,OrderMessage>("t-commodity-order",null,message.orderNumber(),message,headers);
    }
}
