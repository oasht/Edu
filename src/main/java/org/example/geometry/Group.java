package org.example.geometry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Group implements Moveable{

    private String name;
    private List<Moveable> moveables = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void add(Moveable moveable) {
        moveables.add(moveable);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        for (Moveable moveable : moveables) {
            moveable.move(deltaX, deltaY);
        }
    }

    public List<Moveable> getMoveables() {
        return moveables;
    }

}
