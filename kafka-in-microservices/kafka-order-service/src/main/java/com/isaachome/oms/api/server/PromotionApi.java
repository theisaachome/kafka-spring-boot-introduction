package com.isaachome.oms.api.server;

import com.isaachome.oms.api.request.PromotionRequest;
import com.isaachome.oms.command.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotion")
public class PromotionApi {

    @Autowired
    private PromotionService promotionService;
    @PostMapping
    public ResponseEntity<String> create(@RequestBody PromotionRequest promotionRequest){
//        promotionService
     return ResponseEntity.status(HttpStatus.CREATED).body("Successfully-created");
    }
}
