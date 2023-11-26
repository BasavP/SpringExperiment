package com.learn.learn.EventListeners;

import com.learn.learn.Event.StudentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class StudentEventListener {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @EventListener
    @Async
    public void handleStudentEvent(StudentEvent studentEvent){
        log.info("received the event for studentEvent: " + studentEvent );
        log.info("Listener running on thread : {}",Thread.currentThread().getName());
        CompletableFuture future = kafkaTemplate.send("mytopics2", studentEvent.getId(), studentEvent);
            future.whenComplete((result,ex)->{
                if(ex==null){
                    log.info("data published to Kafka successfully");
                }else{
                    log.error("publish not successful");
                }
            });
    }
}
