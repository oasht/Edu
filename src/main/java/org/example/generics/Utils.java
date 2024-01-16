package org.example.generics;

import org.example.geometry.Line;
import org.example.geometry.Point;
import org.example.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void movePoints(Line<? extends Point> l) {

        if (l.getFirst().x >= 0) l.getFirst().x += 10;
        else l.getFirst().x -= 10;
    }

    public static <T extends Number> double getMaxStorage(List<Storage<T>> l) {
        double max = Double.NEGATIVE_INFINITY;
        for (Storage<? extends Number> s : l) {
            if (s.isEmpty()) continue;
            if (s.getValue().doubleValue() > max) {
                max = s.getValue().doubleValue();
            }
        }
        return max;
    }

    public static void putInBox(Box<? super Point3D> b) {
        b.setObject(new Point3D(1, 2, 3));
    }

    public static void fillInList(List<? super Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }


    public static <T, P> List<P> applyToAll(List<T> list, MyFunction<T, P> f) {
        List<P> list2 = new ArrayList<>();
        for (T t : list) {
            list2.add(f.apply(t));
        }
        return list2;
    }

    public static <T> List<T> testAll(List<T> l, MyPredicate<T> mp){
        List <T> list=new ArrayList<>();
        for(T t: l) {
            if(mp.test(t))
                list.add(t);
        }
        return list;
    }

    public static <T> T reduce(List<T> list, MyFunction<List<T>, T> f) {
        return f.apply(list);
    }

}






