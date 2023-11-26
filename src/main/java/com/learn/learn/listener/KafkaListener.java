package com.learn.learn.listener;


import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "mytopics")
    public void listenMethod(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ){
        System.out.println("received message : " + message + "  from  partition : "+partition);
    }
}
