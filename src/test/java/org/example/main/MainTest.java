package org.example.main;

import org.example.entities.birds.Bird;
import org.example.entities.birds.Sparrow;
import org.example.units.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void test_num_sum(){
        Number n1 = 0.6;
        Number n2=6;
        Number n3=new Fraction(1,2);
        assertEquals(7.1, Main.sum(n1,n2,n3));
    }

    @Test
    void test_sing(){
        Bird sparrow1=new Sparrow();
        Bird sparrow2=new Sparrow();
        String result=Main.sing(sparrow1,sparrow2);

        assertEquals("чырык\nчырык", result);
    }
}