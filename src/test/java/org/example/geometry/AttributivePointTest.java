package org.example.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttributivePointTest {
    @Test
    public void create_point(){
        AttributivePoint one =new AttributivePoint();
        one.addAttribute("x", 1);
        one.addAttribute("color", "RED");
        one.addAttribute("y", 2);
        assertEquals(1,one.getAttribute("x"));
        assertEquals("RED",one.getAttribute("color"));
        Integer i = (Integer) one.getAttribute("x");
        assertEquals(1,i);
    }

}