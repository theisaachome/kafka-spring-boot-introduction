package com.isaachome.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaachome.demo.payload.Employee;
import com.isaachome.demo.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeProducer {
    @Value("${spring.kafka.topic.department}")
    private  String departmentTopic;
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    public EmployeeProducer(KafkaTemplate<String, Object> kafkaTemplate,EmployeeService employeeService,ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }
    @Scheduled(fixedRate = 5000)
    public  void  sendMessage() throws JsonProcessingException {
      var data = this.employeeService.createEmployee();
      var json =objectMapper.writeValueAsString(data);
        log.info("[Producer Send Message : {}]",json);
        Message<Employee> message = MessageBuilder
                        .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,departmentTopic)
                        .build();
        kafkaTemplate.send(message);

    }
}
//bin/kafka-console-consumer.sh --topic employeeTopic --from-beginning --bootstrap-server localhost:9092

