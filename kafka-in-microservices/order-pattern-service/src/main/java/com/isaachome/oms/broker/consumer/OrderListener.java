package com.isaachome.oms.broker.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaachome.oms.broker.message.OrderMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class OrderListener {

    // method to listen a topic from Kafka.
    @KafkaListener(topics = "t-commodity-order",groupId = "kafka-order-cg")
    public  void  listen(ConsumerRecord< String,byte[]> record) throws IOException {

        ObjectMapper objectMapper=new ObjectMapper();
        OrderMessage message = objectMapper.readValue(record.value(),OrderMessage.class);

        var totalAmount = message.quantity() * message.price();
        log.info("Processing order {}, item {}, credit card number {}. Total amount for this item is {}",
                message.orderNumber(),message.itemName(),message.creditCardNumber(),totalAmount);
    }
}
