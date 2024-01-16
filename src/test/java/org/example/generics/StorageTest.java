package org.example.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    //5.1.2
    @Test
    void testStorage(){

        Storage<Integer> s1 = new Storage<>(null);
        Storage<Integer> s2 = new Storage<>(99);
        Storage<String> s3 = new Storage<>(null);
        Storage<String> s4 = new Storage<>("Hello");

        assertEquals(0, s1.getOrDefault(0));
        assertEquals(99, s2.getOrDefault(-1));
        assertEquals("default", s3.getOrDefault("default"));
        assertEquals("Hello", s4.getOrDefault("Hello World"));


    }

}