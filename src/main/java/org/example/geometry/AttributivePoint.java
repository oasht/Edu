package org.example.geometry;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class AttributivePoint {
    List<Attribute> attributes;

    public AttributivePoint() {
        attributes = new ArrayList<>();
    }

    public void addAttribute(String name, Object value) {
        for (Attribute a : attributes) {
            if (a.name.equals(name)) {
                a.setValue(value);
                return;
            }
        }
        Attribute attribute = new Attribute(name, value);
        attributes.add(attribute);
    }

    public Object getAttribute(String name) {
        for (Attribute a : attributes) {
            if (a.name.equals(name)) {
                return a.value;
            }
        }
        
        return null;
    }

}

@AllArgsConstructor
@Setter
class Attribute {
    String name;
    Object value;
}
