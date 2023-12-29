package org.example;

public class Human {
    private final FullName fullName;
    private int height;
   private Human father;

    public Human(FullName fullName, int height)
    {
        if(height>0&&height<=500) {
            this.fullName = fullName;
            this.height = height;
        }
        else throw new IllegalArgumentException();
    }
    public Human (String firstName, int height){
        this(new FullName(firstName),height);
    }
    public Human(String firstName, int height, Human father)
    {
        this(new FullName(firstName, father.fullName.name+"ович", father.fullName.surname), height);
    }
    public Human(FullName fullName, int height, Human father)
    {
        this(new FullName(fullName.name, fullName.patronymic==null?father.fullName.name+"ович":fullName.patronymic,
                fullName.surname==null?father.fullName.surname:fullName.surname),height);
    }

    public FullName getFullName() {
        return fullName;
    }

    public Human getFather() {
        return father;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        if (height>0 && height<=500) {
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
