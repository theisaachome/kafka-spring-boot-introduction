package com.isaachome.demo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaachome.demo.payload.Employee;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeConsumer {
    @KafkaListener(topics = "employeeTopic")
    public void consume(Employee employee)throws JsonProcessingException,JsonMappingException {
        // get the Employee Object as String
//        var json = objectMapper.readValue(employee,Employee.class);
        log.info("[Reading Value : {}]",employee.toString());
    }
}
