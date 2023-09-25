package com.isaachome.oms.broker.stream.promotion;

import com.isaachome.oms.broker.message.PromotionMessage;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Configuration
public class PromotionUppercaseJsonStream {

    @Bean
    public KStream<String, PromotionMessage> kStreamPromotionMessageJson(StreamsBuilder builder){
        var sourceStream = builder.stream("t-commodity-promotion", Consumed.with(Serdes.String(),new JsonSerde<>(PromotionMessage.class)));
        var uppercaseStream = sourceStream.mapValues(this::toUpperCaseWithSpringJson);
        sourceStream.print(Printed.<String, PromotionMessage> toSysOut().withLabel("JSON serde original stream"));
        uppercaseStream.print(Printed.<String, PromotionMessage> toSysOut().withLabel("JSON serde uppercase stream"));

        return sourceStream;
    }

    public PromotionMessage toUpperCaseWithSpringJson(PromotionMessage message){
        return  new PromotionMessage(message.promotionCode().toUpperCase());
    }
}
