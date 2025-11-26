package org.example.mail;

import lombok.Data;
import org.example.Gender;

@Data
public class Client {
    private static int counter = 0;

    private final int id;
    private String name;
    private int age;
    private Gender gender;

    public Client(String name, int age, Gender gender) {
        this.id = counter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
