package com.isaachome.oms.utils;
import com.isaachome.oms.broker.message.OrderMessage;
import org.apache.commons.lang3.StringUtils;

public class CommodityStreamUtil {
    public  static OrderMessage markCreditCard(OrderMessage data){
        var tempCard = data.copy();
        var maskedCreditCardNumber = tempCard.creditCardNumber()
                .replaceFirst("\\d{12}", StringUtils.repeat("*",12));

//        tempCard.creditCardNumber();
        return  new OrderMessage(data.orderLocation(),
                data.orderNumber(),
                maskedCreditCardNumber,
                data.orderDateTime(),
                data.itemName(),
                data.price(),
                data.quantity()
        );
    }
}
