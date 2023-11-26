package com.learn.learn.listener;


import com.learn.learn.Entity.Student;
//import com.learn.learn.repo.StudentRepository;
import com.learn.learn.Event.StudentEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
@AllArgsConstructor
@Slf4j
public class KafkaListener {
//    private  StudentRepository studentRepository;
@Autowired
private KafkaTemplate kafkaTemplate;

@Autowired
private ApplicationEventPublisher aep;


    @org.springframework.kafka.annotation.KafkaListener(topics = "mytopics" , concurrency = "2")
    public void listenMethod(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ){
        System.out.println("received message : " + message + "  from  partition : "+partition);
        log.info("thread name : "+ Thread.currentThread().getName());




        StudentEvent studentEvent =  StudentEvent.builder()
                .id(UUID.randomUUID().toString())
                .gender(Student.Gender.MALE)
                .name("someName")
                .grade(10)
                .build();
        aep.publishEvent(studentEvent);
/*        Student student = Student.builder()
                .id(UUID.randomUUID().toString())
                .grade(10)
                .gender(Student.Gender.MALE)
                .name(message)
                .build();
//        studentRepository.save(student);
      log.info("Saved : "+ student +" in  redis");*/
    }
}
