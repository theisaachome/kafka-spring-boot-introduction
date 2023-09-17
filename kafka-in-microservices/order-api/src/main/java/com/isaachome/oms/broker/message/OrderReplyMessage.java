package com.isaachome.oms.broker.message;

public record OrderReplyMessage(String replyMessage) {
    @Override
    public String toString() {
        return "OrderReplyMessage [replyMessage=" + replyMessage + "]";
    }
}
