package org.example.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    //5.1.1
    @Test
    void testBox(){
        Box<Integer> b=new Box<>(3);
        System.out.println(b.getObject());
    }

}