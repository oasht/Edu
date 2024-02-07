package org.example.entities.students;

public class ChangeNameStrategy implements UndoStrategy{
    private final Student student;
    private final String originalName;

    public ChangeNameStrategy(Student student, String originalName) {
        this.student = student;
        this.originalName = originalName;
    }

    @Override
    public void undo() {
        student.setName(originalName);
    }
}
