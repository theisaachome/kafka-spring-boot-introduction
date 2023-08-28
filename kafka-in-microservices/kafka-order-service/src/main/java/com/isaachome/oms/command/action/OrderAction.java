package com.isaachome.oms.command.action;

import com.isaachome.oms.api.request.OrderItemRequest;
import com.isaachome.oms.api.request.OrderRequest;
import com.isaachome.oms.entity.Order;
import com.isaachome.oms.entity.OrderItem;
import com.isaachome.oms.repos.OrderItemRepos;
import com.isaachome.oms.repos.OrderRepos;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class OrderAction {


    @Autowired
    private OrderRepos orderRepos;
    @Autowired
    private OrderItemRepos orderItemRepos;

    // save to database
    public void saveToDatabase(Order order){
        orderRepos.save(order);
        order.getOrderItems().forEach(orderItemRepos::save);
    }


    // publish to kafka message broker


    public Order converToOrder(OrderRequest data){
        var order = new Order();
        order.setCreditCardNumber(data.creditCardNumber());
        order.setOrderLocation(data.orderLocation());
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderNumber(RandomStringUtils.randomAlphabetic(8).toUpperCase());
        var items =data.items().stream().map(this::convertToOrderItem).collect(Collectors.toList());
        items.forEach(item->item.setOrder(order));
        order.setOrderItems(items);
        return  order;
    }
    private OrderItem convertToOrderItem(OrderItemRequest data){
        var orderItems = new OrderItem();
        orderItems.setItemName(data.itemName());
        orderItems.setPrice(data.price());
        orderItems.setQuantity(data.quantity());
        return  orderItems;
    }
}
