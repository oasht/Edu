package org.example;

import java.util.Collections;
import java.util.Random;

public abstract class Bird {
    public String sing(){
        return "Tweet tweet";
    };

}
class Sparrow extends Bird{
    @Override
    public String sing(){
        return "чырык";
    }
}

class Cuckoo extends Bird{
    @Override
    public String sing(){
        return String.join(" ",
                Collections.nCopies(new Random().nextInt(1, 11), "ку-ку")
        );
    }
}


class Parrot extends Bird{
    private String phrase;


    public Parrot(String s){
        if(s.isEmpty()) throw new IllegalArgumentException("String is empty");
        this.phrase =s;
    }
    @Override
    public String sing(){
        return phrase.substring(0, new Random().nextInt(1, phrase.length()+1));
    }
}