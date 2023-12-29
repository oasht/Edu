package org.example.entities.birds;

import java.util.Random;

public class Parrot extends Bird {
    private String phrase;


    public Parrot(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("String is empty");
        this.phrase = s;
    }

    @Override
    public String sing() {
        return phrase.substring(0, new Random().nextInt(1, phrase.length() + 1));
    }
}
