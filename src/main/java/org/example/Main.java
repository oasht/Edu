package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        City city = new City("New York");
//        SmartCity city2 = new SmartCity("Boston");
//
//        city2.addRoad(city, 10);
//        System.out.println(city2+"\n"+city);

        create_and_print_cities();
    }


    public static void create_and_print_cities(){
        City a=new SmartCity("A");
        City d=new SmartCity("D");
        City b=new City("B");
        City c=new City("C");
        City e=new City("E");
        a.addRoad(b,1);
        a.addRoad(c,1);
        d.addRoad(b,1);
        d.addRoad(e,1);
        e.addRoad(c,1);
        b.addRoad(c,1);

        List<City> cities=List.of(a,b,c,d,e);
        for(City city : cities){
            System.out.println(city);
        }

    }
}