package com.isaachome.demo.api;

import com.isaachome.demo.payload.FoodOrder;
import com.isaachome.demo.producer.FoodOrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food/orders")
public class FoodOrderController {


    private  final FoodOrderProducer foodOrderProducer;

    public FoodOrderController(FoodOrderProducer foodOrderProducer) {
        this.foodOrderProducer = foodOrderProducer;
    }

    @PostMapping
    public ResponseEntity<String> orderFood(@RequestBody FoodOrder foodOrder){
        foodOrderProducer.sendMessage(foodOrder);
     return  new ResponseEntity<>("FoodOrder has been sent:", HttpStatus.OK);
    }
}
