package com.isaachome.oms.api.server;

import com.isaachome.oms.api.request.DiscountRequest;
import com.isaachome.oms.command.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount")
public class DiscountApi {

    @Autowired
    private DiscountService discountService;
    @PostMapping
    public ResponseEntity<String> create(@RequestBody DiscountRequest data){
        discountService.createDiscount(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(data.discountCode());
    }
}
