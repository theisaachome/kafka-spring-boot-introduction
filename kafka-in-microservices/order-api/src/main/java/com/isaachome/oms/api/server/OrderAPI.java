package com.isaachome.oms.api.server;

import com.isaachome.oms.api.request.OrderRequest;
import com.isaachome.oms.api.response.OrderResponse;
import com.isaachome.oms.command.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        // save to database
        var orderNumber = orderService.saveOrder(orderRequest);
        // create response
        var response = new OrderResponse(orderNumber);
        // return response
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
