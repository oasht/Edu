package org.example.entities;

public class House {
   //1.4.3
   private final int floors;

    public House(int floors) {
        if(floors<=0)throw new IllegalArgumentException();
            this.floors = floors;
    }
public int getFloors(){return floors;}
    @Override
    public String toString() {
        if(floors%10==1&&floors!=11)
            return "Дом с " + floors + " этажом";
        else
            return "Дом с " + floors + " этажами";
    }


}
