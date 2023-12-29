package org.example.geometry;

import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class FigureTest {
    @Test
    public void create_figures(){
        Figure circle=new Circle(new Point(0,0), 1);
        Figure rectangle=new Rectangle(new Point(0,0), 2,4);
        Figure triangle =new Triangle(new Point(0,0),new Point(1,0), new Point(0,1));

        log.info("Circle: {}", circle.area());
        log.info("Rectangle: {}", rectangle.area());
        log.info("Triangle: {}", triangle.area());

        assertEquals(Math.PI, circle.area());
        assertEquals(8,rectangle.area());
        assertEquals(0.5,triangle.area());
    }

}