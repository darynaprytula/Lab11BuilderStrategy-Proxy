package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class RealImageTest {

    @Test
    public void testDisplayDoesNotThrow() {
        RealImage image = new RealImage("123.jpg");
        assertDoesNotThrow(image::display);
    }

    @Test
    public void testProxyCreatesRealImageOnlyOnce() {
        ProxyImage proxy = new ProxyImage("123.jpg");

        assertDoesNotThrow(proxy::display);

        assertDoesNotThrow(proxy::display);
    }
}
