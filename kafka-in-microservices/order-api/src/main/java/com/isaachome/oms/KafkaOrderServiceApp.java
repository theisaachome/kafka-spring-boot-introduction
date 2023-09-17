package com.isaachome.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class KafkaOrderServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(KafkaOrderServiceApp.class,args);
    }
}
