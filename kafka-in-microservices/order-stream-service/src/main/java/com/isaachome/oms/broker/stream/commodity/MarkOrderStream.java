package com.isaachome.oms.broker.stream.commodity;

import com.isaachome.oms.broker.message.OrderMessage;
import com.isaachome.oms.utils.CommodityStreamUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
public class MarkOrderStream {

    @Bean
    public KStream<String, OrderMessage> kStreamCommodityTrading(StreamsBuilder streamsBuilder){
        var stringSerde=Serdes.String();
        var orderSerde=new JsonSerde<>(OrderMessage.class);
        var maskedCreditCardStream = streamsBuilder.stream("t-commodity-order", Consumed.with(stringSerde,orderSerde))
                .mapValues(CommodityStreamUtil::markCreditCard);
        maskedCreditCardStream.print(Printed.toSysOut());
        maskedCreditCardStream.to("t-commodity-order-masked", Produced.with(stringSerde,orderSerde));
        maskedCreditCardStream.print(Printed.toSysOut());
        return  maskedCreditCardStream;
    }
}
