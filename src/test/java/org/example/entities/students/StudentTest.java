package org.example.entities.students;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void StudentUndoSaveTest() {

        Student student = new Student("Vasia");

        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);


    }

    }
