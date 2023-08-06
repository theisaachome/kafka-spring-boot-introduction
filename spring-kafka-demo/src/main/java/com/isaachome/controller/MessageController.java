package com.isaachome.controller;

import com.isaachome.kafka.JsonKafkaProducer;
import com.isaachome.kafka.KafkaProducer;
import com.isaachome.payload.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private  final KafkaProducer kafkaProducer;
    private  final JsonKafkaProducer jsonKafkaProducer;

    public MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return  new ResponseEntity<>("Message sent to Topic",HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/kafka/publish-json
    @GetMapping("/publish-json")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return  new ResponseEntity<>("Message sent to Topic",HttpStatus.OK);
    }
}
