package org.example.main;

import lombok.extern.log4j.Log4j2;
import org.example.cities.City;
import org.example.cities.SmartCity;
import org.example.entities.Meowable;
import org.example.entities.birds.Bird;
import org.example.geometry.*;

import java.util.Collection;
import java.util.List;

import static java.lang.Math.pow;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@Log4j2
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

//        City city = new City("New York");
//        SmartCity city2 = new SmartCity("Boston");
//
//        city2.addRoad(city, 10);
//        System.out.println(city2+"\n"+city);

        // create_and_print_cities();

        // meow(new Cat("a"), new Cat("b"));

//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        String b = sc.nextLine();
//        log.info(myPow(a,b));
       // if (args.length >= 2) log.info(myPow(args[0], args[1]));

//        Point p1=new Point(0,1);
//        java.awt.Point p2=new java.awt.Point(2,3);

//        Fraction f1=new Fraction(3,2);
//        Fraction f2=new Fraction(3,3);
//        System.out.println(f1.equals(f2));

//        Point p1=new Point(3,2);
//        Point p2=new Point(3,2);
//        System.out.println(p1.equals(p2));

//        Line l1=new Line(new Point(3,2), new Point(3,3));
//        Line l2=new Line(new Point(3,2), new Point(2,3));
//        System.out.println(l1.equals(l2));

//        PolyLine l1=new PolyLine(new Point(3,2), new Point(3,3),new Point(3,3));
//        PolyLine l2=new PolyLine(new Point(3,2), new Point(3,3));
//        System.out.println(l1.equals(l2));

        Line l1=new Line(new Point(3,2), new Point(3,3));
        Line clone=(Line)l1.clone();
        System.out.println(clone);



    }


    public static void create_and_print_cities() {
        City a = new SmartCity("A");
        City d = new SmartCity("D");
        City b = new City("B");
        City c = new City("C");
        City e = new City("E");
        a.addRoad(b, 1);
        a.addRoad(c, 1);
        d.addRoad(b, 1);
        d.addRoad(e, 1);
        e.addRoad(c, 1);
        b.addRoad(c, 1);

        List<City> cities = List.of(a, b, c, d, e);
        for (City city : cities) {
            System.out.println(city);
        }

    }


    public static double sum(Number... numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static String sing(Bird... birds) {
        StringBuilder s = new StringBuilder();
        for (Bird b : birds) {
            s.append(b.sing());
            s.append("\n");
        }
        return s.toString().trim();
    }

    public static double totalArea(Figure... figures) {
        double sum = 0;
        for (Figure f : figures) {
            sum += f.area();
        }
        return sum;
    }

    public static void meow(Meowable... meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }

    public static double totalLength(Measurable... measurables) {
        double tot_length = 0;
        for (Measurable m : measurables) {
            tot_length += m.length();
        }
        return tot_length;
    }

    public static PolyLine unitedLine(Collection<Chainable> chainables) {

        PolyLine res = new PolyLine();
        for (Chainable ch : chainables) {
            for (Point point : ch.getLine().getPoints()) {
                res.adding(point);
            }
        }
        return res;
    }

    public static double myPow(String x, String y) {
        return pow(Integer.parseInt(x), Integer.parseInt(y));
    }
}