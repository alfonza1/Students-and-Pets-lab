package io.zipcoder;
import io.zipcoder.gradedStudents.Classroom;
import io.zipcoder.gradedStudents.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertNotEquals;

public class ClassroomTest {
    private Classroom classroom;

    @Test
    public void testAddStudent() {
        classroom = new Classroom(1);
        Double[] examScores = {100.0, 90.0, 95.0};
        Student student = new Student("fonza", "jones", examScores);

        classroom.addStudent(student);
        Student[] students = classroom.getStudents();
        Assert.assertEquals(1, students.length);
        Assert.assertEquals(student, students[0]);
    }

    @Test
    public void testRemoveStudent() {

        Double[] scores = {100.0,100.0};

        Student student1 = new Student("fonza", "jones",scores);
        Student student2 = new Student("xy", "z",scores);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom(students);


        Student[] updatedStudents = classroom.removeStudent("fonza", "jones");


        for (Student student : updatedStudents) {
            if (student != null) {
                assertNotEquals("fonza", student.getFirstName());
                assertNotEquals("jones", student.getLastName());
            }
        }
    }


    @Test
    public void testGetAverageExamScore() {
        classroom = new Classroom(2);
        Double[] examScores1 = {100.0, 90.0, 95.0};
        Student student1 = new Student("fonza", "jones", examScores1);

        Double[] examScores2 = {80.0, 85.0, 90.0};
        Student student2 = new Student("james", "sal", examScores2);

        classroom.addStudent(student1);
        classroom.addStudent(student2);

        double averageScore = classroom.getAverageExamScore();
        Assert.assertEquals(90.0, averageScore, 0.01);
    }

    @Test
    public void testGetStudentsByScore() {
        classroom = new Classroom(3);
        Double[] examScores1 = {100.0, 90.0, 95.0};
        Student student1 = new Student("fonza", "jones", examScores1);

        Double[] examScores2 = {80.0, 85.0, 90.0};
        Student student2 = new Student("mikaila", "idk", examScores2);

        Double[] examScores3 = {95.0, 95.0, 90.0};
        Student student3 = new Student("ray", "Johnson", examScores3);

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        Student[] studentsByScore = classroom.getStudentsByScore();

        Assert.assertEquals(student1, studentsByScore[0]);
        Assert.assertEquals(student3, studentsByScore[1]);
        Assert.assertEquals(student2, studentsByScore[2]);
    }

    @Test
    public void testGetGradeBook() {
        classroom = new Classroom(2);
        Double[] examScores1 = {100.0, 90.0, 95.0};
        Student student1 = new Student("fonza", "j", examScores1);

        Double[] examScores2 = {80.0, 85.0, 90.0};
        Student student2 = new Student("Jane", "s", examScores2);


        classroom.addStudent(student1);
        classroom.addStudent(student2);


        Map<Student, String> gradeBook = classroom.getGradeBook();


        Assert.assertEquals("95.0", gradeBook.get(student1)); // Average of 100, 90, 95
        Assert.assertEquals("85.0", gradeBook.get(student2)); // Average of 80, 85, 90
    }
}
