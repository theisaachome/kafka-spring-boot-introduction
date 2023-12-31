package com.isaachome.oms.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record OrderMessage(
        String orderLocation,
        String orderNumber,
        String creditCardNumber,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime orderDateTime,
        String itemName,
        int price,
        int quantity
) {
        @Override
        public String toString() {
                return "OrderMessage [orderLocation=" + orderLocation + ", orderNumber=" + orderNumber + ", creditCardNumber="
                        + creditCardNumber + ", orderDateTime=" + orderDateTime + ", itemName=" + itemName + ", price=" + price
                        + ", quantity=" + quantity + "]";
        }

        public OrderMessage copy(){
                return  new OrderMessage(this.orderLocation,this
                        .orderNumber,this.creditCardNumber,this.orderDateTime,this.itemName,this.price,this.quantity);
        }
        public String setMaskedCreditCardNumber(){
                return this.creditCardNumber;
        }
}