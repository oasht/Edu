package org.example.cities;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Road road = (Road) obj;
        return cost == road.cost && wayTo==road.wayTo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(wayTo.getName(), cost);
    }

    @Override
    public String toString() {
        return wayTo.getName()+"(cost "+cost+")";
    }
}
