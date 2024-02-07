package org.example.entities.students;

import lombok.Getter;
import org.example.units.Comparable;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    @Getter
    private String name;
   private final List<Integer> grades=new ArrayList<>();
    private UndoStrategy undoStrategy;
    @Getter
    private Integer lastRemovedGrade;

    private String originalName;



    public Student(String name) {
        this.name = name;
        this.originalName=name;
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
        originalName = this.name;
        this.name = name;
        undoStrategy = new ChangeNameStrategy(this, originalName);
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
    public void removeGrade(int index) {
        if (index >= 0 && index < grades.size()) {
            lastRemovedGrade = grades.remove(index);
            undoStrategy = new RemoveGradeStrategy(this, index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void undo() {
        if (undoStrategy != null) {
            undoStrategy.undo();
            undoStrategy = null;
        }
    }

    public Save getSave() {
        return new Save(originalName, grades);
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
}
