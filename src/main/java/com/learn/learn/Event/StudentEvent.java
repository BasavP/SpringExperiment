package com.learn.learn.Event;


import com.learn.learn.Entity.Student;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentEvent {
    public enum Gender {
        MALE,FEMALE
    }

    private String id ;
    private String name;
    private Student.Gender gender;
    private int grade;
}
