package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class City {
    private String name;
    private List<Road> roads=new ArrayList<>();
    public City(String name, Road...roads){
        this.name=name;
       this.roads= Arrays.stream(roads).collect(Collectors.toList());
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasRoadTo(City target)
    {
        boolean hasRoad = false;
        for(Road r:roads){
            if(r.getWayTo()==target){
                hasRoad=true;
                break;
            }
        }
        
        
        
        
        return hasRoad;
    }
    public void deleteByIndex(int n)
    {
        roads.remove(n);
    }
  
    public void deleteByRoad(Road road) {
        roads.remove(road);
    }
   
    public void addRoad(City target, int price){
        for(Road r:roads){
            if(r.getWayTo()==target){
                r.setCost(price);
                return;
            }
        }
        roads.add(new Road(target,price));
    }
    
    @Override
    public String toString() {
        return "City " + name + " has roads to " + roads;
    }
}
