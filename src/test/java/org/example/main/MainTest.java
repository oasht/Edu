package org.example.main;

import lombok.extern.log4j.Log4j2;
import org.example.entities.birds.Bird;
import org.example.entities.birds.Sparrow;
import org.example.geometry.*;
import org.example.units.Fraction;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Log4j2
class MainTest {
    @Test
    void test_num_sum(){
        Number n1 = 0.6;
        Number n2=6;
        Number n3=new Fraction(1,2);
        assertEquals(7.1, Main.sum(n1,n2,n3));
    }

    @Test
    void test_num_sum_2(){
        Number n1 = 0.6;
        Number n2=6;
        Number n3=new Fraction(1,2);
        Number n4=new BigInteger("12345678912345678912");
        log.info("result: {}",Main.sum(n1,n2,n3,n4));
        assertEquals(1.234567891234568E19, Main.sum(n1,n2,n3,n4));
    }

    @Test
    void test_sing(){
        Bird sparrow1=new Sparrow();
        Bird sparrow2=new Sparrow();
        String result=Main.sing(sparrow1,sparrow2);

        assertEquals("чырык\nчырык", result);
    }

    @Test
    void test_total_area(){
        Figure rect1=new Rectangle(new Point(0,0),2,4 );
        Figure rect2=new Rectangle(new Point(0,0),3,5 );
        double res=Main.totalArea(rect1, rect2);
        assertEquals(23, res);
    }

    @Test
    void test_united_line(){
        Chainable triangle=new Triangle(new Point(0,0), new Point(1,1), new Point (2,2));
        Chainable square=new Square(new Point(0,0), 3);
        Chainable rectangle=new Rectangle(new Point(0,0),2,3);
        List<Chainable> chainables = List.of(triangle,square,rectangle);
        PolyLine res= Main.unitedLine(chainables);
        assertEquals(res.getPoints().size(), 11);

    }
}