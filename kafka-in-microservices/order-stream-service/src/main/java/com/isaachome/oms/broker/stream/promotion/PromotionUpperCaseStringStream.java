package com.isaachome.oms.broker.stream.promotion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaachome.oms.broker.message.PromotionMessage;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PromotionUpperCaseStringStream {

    @Autowired
    private ObjectMapper objectMapper;
    @Bean
    public KStream<String,String> kStreamPromotionUppercase(StreamsBuilder builder){
        var sourceStream = builder.stream("t-commodity-promotion", Consumed.with(Serdes.String(),Serdes.String()));
        // business logic go here
//        var uppercaseStream = sourceStream.mapValues(d->d.toUpperCase());
        var uppercaseStream = sourceStream.mapValues(this::upperCasePromotionCodeWithObjectMapper);
        uppercaseStream.to("t-commodity-promotion-uppercase");
        sourceStream.print(Printed.<String, String>toSysOut().withLabel("Original stream"));
        uppercaseStream.print(Printed.<String, String>toSysOut().withLabel("Uppercase stream"));
        return sourceStream;
    }

    public String upperCasePromotionCodeWithObjectMapper(String data){
        try{
         var originalData= objectMapper.readValue(data,PromotionMessage.class);
         var converted = new PromotionMessage(originalData.promotionCode().toUpperCase());
         return  objectMapper.writeValueAsString(converted);
        }catch (Exception e){
            return "";
        }
    }
}
