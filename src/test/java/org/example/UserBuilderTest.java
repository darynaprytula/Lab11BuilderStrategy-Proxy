package org.example;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class UserBuilderTest {

    @Test
    public void testUserBuilderCreatesUserCorrectly() {
        User user = User.builder()
                .name("Roman")
                .age(20)
                .gender(Gender.MALE)
                .weight(70.5)
                .height(180)
                .build();

        assertEquals("Roman", user.getName());
        assertEquals(20, user.getAge());
        assertEquals(Gender.MALE, user.getGender());
        assertEquals(70.5, user.getWeight(), 0.01);
        assertEquals(180, user.getHeight(), 0.01);
    }

    @Test
    public void testUserBuilderOptionalFields() {
        User user = User.builder()
                .name("Daryna")
                .gender(Gender.FEMALE)
                .build();

        assertEquals("Daryna", user.getName());
        assertEquals(Gender.FEMALE, user.getGender());
        assertEquals(0, user.getAge());
        assertEquals(0.0, user.getWeight(), 0.01);
        assertEquals(0.0, user.getHeight(), 0.01);
    }
}
