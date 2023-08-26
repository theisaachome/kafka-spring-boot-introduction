package com.isaachome.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class KafkaConsumerApp
{
    public static void main( String[] args )
    {

        SpringApplication.run(KafkaConsumerApp.class,args);
    }
}
