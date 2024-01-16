package org.example.generics;

public class Storage <T>{
    private final T value;

    public Storage (T value){
        this.value=value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }


    public T getOrDefault(T def){
        if(value==null){
            return def;
        }
        return value;
    }

    public T getValue() {
        return value;
    }
}
