package org.example.entities;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FullName {

    public final String name;
    public final String patronymic;
    public final String surname;


    public FullName(String name, String patronymic, String surname)
    {
        if(name==null) name="";
        if(patronymic==null) patronymic="";
        if(surname==null) surname="";
        if(!name.isEmpty()||!patronymic.isEmpty()||!surname.isEmpty()) {
            this.name = name;
            this.patronymic = patronymic;
            this.surname = surname;
        }
        else throw new IllegalArgumentException();
    }
    public FullName(String name)
    {
        this(name, "", "");
    }
    public FullName(String name, String surname){
        this(name,"",surname);
    }


    @Override
    public String toString() {
      String str= "";
        if(Objects.equals(name, "")) str+="";
        else str+=name+" ";
        if(Objects.equals(patronymic, "")) str+="";
        else str+=patronymic+" ";
        if(Objects.equals(surname, "")) str+="";
        else str+=surname;
      return str;
    }
}
