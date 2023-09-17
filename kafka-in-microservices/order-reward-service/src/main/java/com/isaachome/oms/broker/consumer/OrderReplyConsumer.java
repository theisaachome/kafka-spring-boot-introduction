package com.isaachome.oms.broker.consumer;

import com.isaachome.oms.broker.message.OrderMessage;
import com.isaachome.oms.broker.message.OrderReplyMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderReplyConsumer {

    @KafkaListener(topics = "t-commodity-order",groupId = "kafka-order-cg")
    @SendTo("t-commodity-order-reply")
    public OrderReplyMessage listen(ConsumerRecord<String, OrderMessage>records){
        var headers = records.headers();
        var orderMessage = records.value();
        log.info("Processing Order: {}, item: {}, credit card number: {}",
                orderMessage.orderNumber(),orderMessage.itemName(),orderMessage.creditCardNumber());

        log.info("Headers: ");
        headers.forEach(data->log.info(" Key:{}, Value: {}",data.key(),data.value()));

        var headerValue = ObjectUtils.isEmpty(headers.lastHeader("surpriseBonus").value())?"0":new String(headers.lastHeader("surpriseBonus").value());
        var bonusPercentage = Integer.parseInt(headerValue);
        var bonusAmount = (bonusPercentage/100d) * orderMessage.price() * orderMessage.quantity();

        log.info("Bonus Amount: {}",bonusAmount);

       return new OrderReplyMessage("Order :"+ orderMessage.orderNumber() + ", Item : "+orderMessage.itemName() + " Processed.");

    }
}
