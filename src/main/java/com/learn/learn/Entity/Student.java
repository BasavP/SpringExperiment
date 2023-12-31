package com.learn.learn.Entity;


import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    public enum Gender {
        MALE,FEMALE
    }

    private String id ;
    private String name;
    private Gender gender;
    private int grade;
}
