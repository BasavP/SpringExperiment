package com.learn.learn.Entity;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
public class Student {
    public enum Gender {
        MALE,FEMALE
    }

    private String id ;
    private String name;
    private Gender gender;
    private int grade;
}
