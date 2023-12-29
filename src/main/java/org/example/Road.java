package org.example;

public class Road {
    private City wayTo;
    private int cost;
    public Road(City wayTo, int cost) {
        this.wayTo = wayTo;
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public City getWayTo() {
        return new City(wayTo.getName());
    }



    @Override
    public String toString() {
        return wayTo.getName()+"(cost "+cost+")";
    }
}
