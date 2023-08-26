package com.isaachome.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {
    @Value("${spring.kafka.topic.department}")
    private  String departmentTopic;

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name(departmentTopic).build();
    }
    @Bean
    public NewTopic foodTopic(){
       return  TopicBuilder.name("foodOrderTopic").build();
    }
}
