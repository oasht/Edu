package org.example.entities.students;

import lombok.Getter;
import org.example.units.Comparable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Student implements Comparable<Student>{
    @Getter
    private String name;
   private final List<Integer> grades=new ArrayList<>();
   private Deque<Action> actions=new ArrayDeque();




    public Student(String name) {
        this.name = name;
    }

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

    public void setName(String name) {
        String tmp=this.name;
        actions.push(()->this.name=tmp);
        this.name = name;
    }

    public void undo(){
        actions.pop().make();
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
                int index = this.grades.size() - 1;
                actions.push(() -> this.grades.remove(index));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
public void removeGrade(int index){
        int grade=grades.get(index);
        actions.push(()->grades.add(index, grade));
        this.grades.remove(index);
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
    public int compare(Student st) {
        double thisMiddleGrade = this.getMiddleGrade();
        double otherMiddleGrade = st.getMiddleGrade();

        return Double.compare(thisMiddleGrade, otherMiddleGrade);
    }
    @Override
    public String toString() {
        if (grades.isEmpty())
            return name + " без оценок";
        return name + ":" + grades;
    }

    public Save getSave(){
        return new SaveImpl();
    }
    private class SaveImpl implements Save{
        String name=Student.this.name;
        List<Integer> grades=new ArrayList<>(Student.this.grades);

        @Override
        public void load(){
            Student.this.name=name;
            Student.this.grades.clear();
            Student.this.grades.addAll(grades);
        }

    }
}
