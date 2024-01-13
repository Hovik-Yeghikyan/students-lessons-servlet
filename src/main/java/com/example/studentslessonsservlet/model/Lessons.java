package com.example.studentslessonsservlet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lessons {

    private int id;
    private String name;
    private double duration;
    private String lecturerName;
    private double price;
}
