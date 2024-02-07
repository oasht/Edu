package org.example.entities.students;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Save {
    @Getter
    private final String nameBackup;
    private final List<Integer> gradesBackup;

    public Save(String nameBackup, List<Integer> gradesBackup) {
        this.nameBackup = nameBackup;
        this.gradesBackup = new ArrayList<>(gradesBackup);
    }

    public List<Integer> getGradesBackup() {
        return new ArrayList<>(gradesBackup);
    }
}
