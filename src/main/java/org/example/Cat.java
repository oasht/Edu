package org.example;

public class Cat {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(name + ": мяу!");
    }

    public void makeSound(int n) {
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
        return "cat: " + name;
    }
}
