package org.example.generics;

public class Box<T> {
    private T obj;

    public Box() {
        this.obj = null;
    }

    public Box(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        T tmp = obj;
        obj = null;
        return tmp;
    }


    public boolean isEmpty() {
        return this.obj == null;
    }

    public void setObject(T obj) {
        if (this.obj == null) this.obj = obj;
        else throw new RuntimeException("This box is full");
    }
}
