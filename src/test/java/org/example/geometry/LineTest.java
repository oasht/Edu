package org.example.geometry;

import org.junit.jupiter.api.Test;

class LineTest {

    //5.1.5
    @Test
    void testLine(){
        Line<Point> line=Line.of(new Point3D(0,0,0), new Point3D(1,0,0));
        System.out.println(line);
    }


}