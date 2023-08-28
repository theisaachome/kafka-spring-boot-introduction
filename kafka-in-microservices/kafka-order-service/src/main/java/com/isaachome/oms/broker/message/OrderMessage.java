package com.isaachome.oms.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
) {}