# kafka-spring-boot-introduction

## download Kafka
run zookeeper 
```sh
bin/zookeeper-server-start.sh config/zookeeper.properties
```
run service broker
```sh
# Start the Kafka broker service
bin/kafka-server-start.sh config/server.properties
```
## Create spring boot project

## Maven dependencies 

```sh
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

---
### Configure Kafka Producer and Consumer
```sh 
spring.kafka.consumer.bootstrap-servers: localhost:9092
spring.kafka.consumer.group_id: myGroup
spring.kafka.consumer.auto-offset-reset: earliest
spring.kafka.consumer.key-deserializer= org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer= org.apache.kafka.common.serialization.StringDeserializer

spring.kafka.producer.bootstrap-servers: localhost:9092
spring.kafka.producer.key-deserializer= org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-deserializer= org.apache.kafka.common.serialization.StringSerializer


```

---
### Configure Kafka Topic in Cluster 

```sh 
@Configuration
public class KafkaTopicConfig {
    public NewTopic highwayTopic(){
        return TopicBuilder.name("highway65")
                .build();
    }
}
```

---

### Create Kafka Producer 
```sh

@Service
public class KafkaProducer {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private  final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void sendMessage(String message){
        LOGGER.info(String.format("Message sent : %s",message));
        kafkaTemplate.send("highway65",message);
    }

}
```

----

### Create REST to send message

```sh
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private  final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return  new ResponseEntity<>("Message sent to Topic",HttpStatus.OK);
    }
}
```

---


### Create Kafka Consumer

bin/kafka-console-consumer.sh --topic highway65 --from-beginning --bootstrap-server localhost:9092

```sh

@Service
public class KafkaConsumer {
    private  static  final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "highway65",groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s",message));

    }
}
```