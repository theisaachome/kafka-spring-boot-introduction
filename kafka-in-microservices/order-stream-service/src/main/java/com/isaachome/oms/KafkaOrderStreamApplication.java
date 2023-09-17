package com.isaachome.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class KafkaOrderStreamApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(KafkaOrderStreamApplication.class,args);
    }
}
