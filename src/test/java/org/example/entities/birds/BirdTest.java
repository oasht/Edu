package org.example.entities.birds;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {
    @Test
    public void bird_produce_string()
    {
        Bird cuckoo=new Cuckoo();
        Bird parrot= new Parrot("abcdef");
        Bird sparrow=new Sparrow();

        String cuckooString = cuckoo.sing();
        String parrotString = parrot.sing();
        String sparrowString = sparrow.sing();

        System.out.println(cuckooString);
        System.out.println(parrotString);
        System.out.println(sparrowString);
        assertTrue(cuckooString.contains("ку-ку"));
        assertTrue("abcdef".contains(parrotString));
        assertEquals(sparrowString, "чырык");
    }
}