package org.example;

import org.example.mail.Client;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testClientIdAutoIncrement() {
        Client c1 = new Client("Daryna", 20, Gender.FEMALE);
        Client c2 = new Client("Bob", 25, Gender.MALE);

        assertEquals(0, c1.getId());
        assertEquals(1, c2.getId());
    }
}
