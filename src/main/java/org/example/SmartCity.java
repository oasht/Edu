package org.example;

public class SmartCity extends City{
    public SmartCity(String name, Road... roads) {
        super(name, roads);
    }

    @Override
    public void addRoad(City target, int price) {
        super.addRoad(target, price);
        if(!target.hasRoadTo(this))
            target.addRoad(this,price);
    }

    @Override
    public String toString() {
        return "SmartCity "+getName() + " has road to " + getRoads();
    }
}
