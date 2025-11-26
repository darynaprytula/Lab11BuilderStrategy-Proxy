package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProxyImageTest {

    @Test
    public void testRealImageIsNotCreatedInitially() {
        ProxyImage proxy = new ProxyImage("123.jpg");
        assertNull(proxy.getRealImage());
    }

    @Test
    public void testRealImageCreatedOnFirstDisplay() {
        ProxyImage proxy = new ProxyImage("123.jpg");
        proxy.display();
        assertNotNull(proxy.getRealImage());
    }

    @Test
    public void testRealImageNotRecreated() {
        ProxyImage proxy = new ProxyImage("123.jpg");
        proxy.display();
        RealImage first = proxy.getRealImage();
        proxy.display();
        RealImage second = proxy.getRealImage();

        assertSame(first, second);
    }
}
