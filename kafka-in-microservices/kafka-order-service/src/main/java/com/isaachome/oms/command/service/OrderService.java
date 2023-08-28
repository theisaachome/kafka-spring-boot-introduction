package com.isaachome.oms.command.service;

import com.isaachome.oms.api.request.OrderRequest;
import com.isaachome.oms.command.action.OrderAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderAction orderAction;

    public  String saveOrder(OrderRequest orderRequest){
        var order =orderAction.converToOrder(orderRequest);
        orderAction.saveToDatabase(order);

        // flatten message & publish (to implement)
        return  order.getOrderNumber();
    }
}
