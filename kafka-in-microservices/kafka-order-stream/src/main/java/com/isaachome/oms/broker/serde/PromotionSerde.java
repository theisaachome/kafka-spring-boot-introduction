package com.isaachome.oms.broker.serde;

import com.isaachome.oms.broker.message.PromotionMessage;

public class PromotionSerde extends  CustomJsonSerde<PromotionMessage> {
    public PromotionSerde(CustomJsonSerializer<PromotionMessage> serializer, CustomJsonDeserializer<PromotionMessage> deserializer) {
        super(serializer, deserializer);
    }
}
