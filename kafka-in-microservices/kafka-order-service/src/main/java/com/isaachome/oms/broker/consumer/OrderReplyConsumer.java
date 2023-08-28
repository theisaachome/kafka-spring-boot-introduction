package com.isaachome.oms.broker.consumer;
import com.isaachome.oms.broker.message.OrderReplyMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderReplyConsumer {
    @KafkaListener(topics = "t-commodity-order-reply")
    public void listen(OrderReplyMessage message) {
        log.info("Reply message received : {}", message);
    }

}
