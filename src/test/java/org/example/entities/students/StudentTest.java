package org.example.entities.students;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StudentTest {

    @Test
    void StudentUndoSaveTest() {

        Student student = new Student("Vasia");

        student.addGrade(3);
        student.addGrade(4);
        student.addGrade(5);

        Save save=student.getSave();
        student.setName("Anna");
        student.undo();
        System.out.println(student);
        student.setName("Anna");
        student.removeGrade(1);
        System.out.println(student);

        assertEquals("Vasia", save.getNameBackup());
        assertEquals("[3, 4, 5]", save.getGradesBackup().toString());
    }
    }
