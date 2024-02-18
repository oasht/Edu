package org.example.entities.students;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void StudentUndoSaveTest() {

        Student st1=new Student("Vasya", 5,4,3);

        System.out.println(st1);
        st1.addGrade(5);
        st1.addGrade(3);
        System.out.println(st1);
        st1.undo();
        st1.undo();
        System.out.println(st1);
        Save save=st1.getSave();
        st1.removeGrade(1);
        st1.removeGrade(1);
        System.out.println(st1);
        st1.undo();
        System.out.println(st1);
        st1.setName("Petya");
        System.out.println(st1);
        st1.undo();
        System.out.println(st1);
        save.load();
        System.out.println(st1);



    }

    }
