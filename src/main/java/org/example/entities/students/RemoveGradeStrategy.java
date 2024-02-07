package org.example.entities.students;

public class RemoveGradeStrategy implements UndoStrategy {
    private final Student student;
    private final int removedGradeIndex;

    public RemoveGradeStrategy(Student student, int removedGradeIndex) {
        this.student = student;
        this.removedGradeIndex = removedGradeIndex;
    }

    @Override
    public void undo() {
        student.getGrades().add(removedGradeIndex, student.getLastRemovedGrade());
    }
}
