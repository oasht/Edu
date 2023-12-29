package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
   private List<Integer> grades=new ArrayList<>();

    public Student(String name, int... args) {
        this.name = name;
        for (int grade : args) {
            if (checkGrade(grade)) {
                this.grades.add(grade);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    private boolean checkGrade(int grade) {
        if (grade>1 && grade<6) return true;
        return false;
    }

    public void addGrade(int... grades) {
        for (int grade : grades) {
            if (checkGrade(grade)) {
                this.grades.add(grade);
            }  else throw new IllegalArgumentException();

        }
    }

    public double getMiddleGrade() {
        int sum = 0;
        if (grades.isEmpty())
            return 0;
        for (int i=0; i<grades.size(); i++) {
            sum += grades.get(i);
        }
        return (double) sum/grades.size();
    }

    public boolean isExcellentStudent() {
        if (this.grades.isEmpty())
            return false;
        if (this.grades.contains(1) || this.grades.contains(2) || this.grades.contains(3) || this.grades.contains(4))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (grades.isEmpty())
            return name + " без оценок";
        return name + ":" + grades;
    }
}
