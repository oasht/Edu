package org.example.generics;

import org.example.geometry.Line;
import org.example.geometry.Point;
import org.example.geometry.Point3D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UtilsTest {

    //5.2.1
    @Test
    void testMoveLine() {
        Line<Point3D> line = Line.of(new Point3D(-5, 1, 0), new Point3D(0, 1, 0));
        Utils.movePoints(line);
        System.out.println(line);
    }

    //5.2.2
    @Test
    void testGetMaxStorage() {
        Storage<Double> st1 = new Storage<>(4.5);
        Storage<Double> st2 = new Storage<>(-4.5);
        Storage<Double> st3 = new Storage<>(0.0);
        var list = List.of(st1, st2, st3);
        List<Storage<Double>> list2 = List.of(st1, st2, st3);
        System.out.println(Utils.getMaxStorage(list));
        System.out.println(Utils.getMaxStorage(list2));
    }

    //5.2.3
    @Test
    void testPutInBox() {
        Box<Point> box = new Box<>();
        Utils.putInBox(box);
        System.out.println(box.getObject());
    }



    //5.2.4
    @Test
    void TestFillInList(){
        List<Integer> list=new ArrayList<>();
        Utils.fillInList(list);
        System.out.println(list);
    }
    

    //5.3.1
    @Test
    void TestApplyToAll(){
        List<String> l1= List.of("qwerty", "asfg", "zx");
        var l2 = Utils.applyToAll(l1, s -> s.length());
        System.out.println(l2);

        List<Integer> l3=List.of(1,-3,7);
        var l4 = Utils.applyToAll(l3, s -> {
            if(s<0) return -s;
            return s;
        });
        System.out.println(l4);

        List<int[]> l5 = List.of(new int[]{1,2,3}, new int[]{4,5,6});
        var l6 = Utils.applyToAll(l5, s -> {
            Integer max = null;
            for(int i : s) {
                if(max == null || i>max)
                    max=i;
            }
            return max;
        });
        System.out.println(l6);
    }

    //5.3.2
    @Test
    void testTest(){
        List<String> l1= List.of("qwerty", "asfg", "zx");
        var l2=Utils.testAll(l1, s->s.length()>3);
        System.out.println(l2);

        List<Integer> l3=List.of(1,-3,7);
        var l4=Utils.testAll(l3, s->s>0);
        System.out.println(l4);
    }

    //5.3.3
    @Test
    void testReduce(){
        List<Integer> l1 = List.of(1,2,3);
        var l2 = Utils.reduce(l1, s -> {
            Integer res = 0;
            for(int i : s) {
                res+=i;
            }
            return res;
        });
        System.out.println(l2);
    }
}