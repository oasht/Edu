package org.example.entities;

import org.example.entities.students.Student;
import org.junit.jupiter.api.Test;

class StudentTest {

    //5.1.4
    @Test
    void compareStudentGrades(){
        Student st1=new Student("Vasya", 5,4,3);
        Student st2=new Student("Petya", 2,4,5);
        System.out.println(st1.compare(st2));
    }

}