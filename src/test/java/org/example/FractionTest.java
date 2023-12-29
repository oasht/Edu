package org.example;

import org.example.units.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    
    @Test
    public void testFraction() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(1, fraction.getNumerator());
        assertEquals(2, fraction.getDenominator());

        Fraction fraction2 = new Fraction(1, 2);
    }

}