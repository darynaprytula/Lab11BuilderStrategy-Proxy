package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
}
