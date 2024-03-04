package org.example.entities;

public class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        StringBuilder sound = new StringBuilder(name +": ");
        if (n>1) {
            for (int i = 0; i < n - 1; i++) {
                sound.append("мяу-");
            }
            sound.append("мяу!");
            System.out.println(sound);
        }
        if (n==1) {
            sound.append("мяу!");
            System.out.println(sound);
        }
        if (n<=0) {
            throw new IllegalArgumentException();
        }

    }

    public String toString() {
        return this.getClass().getName()+" " + name;
    }


}
