package io.zipcoder.gradedStudents;


import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Classroom classroom = new Classroom(3);

        // Create students
        Double[] examScores1 = {100.0, 90.0, 95.0};
        Student student1 = new Student("Alfonza", "Jones", examScores1);

        Double[] examScores2 = {80.0, 85.0, 90.0};
        Student student2 = new Student("Aubrey", "Graham", examScores2);

        Double[] examScores3 = {75.0, 85.0, 70.0};
        Student student3 = new Student("Neil", "Degrasse Tyson", examScores3);

        // Add students to the classroom
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        // Get all students in the classroom
        Student[] students = classroom.getStudents();
        System.out.println("Students in the classroom:");
        for (Student student : students) {

            System.out.println(student.getFirstName() + " " + student.getLastName());

        }

        // Get the average exam score for the classroom
        double classAverage = classroom.getAverageExamScore();
        System.out.println("Class average exam score: " + classAverage);

        // Get the students sorted by score
        Student[] studentsByScore = classroom.getStudentsByScore();
        System.out.println("Students sorted by score:");
        for (Student student : studentsByScore) {

            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - Average Score: " + student.getAverageExamScore());

        }

        // Get the grade book for the classroom
        Map<Student, String> gradeBook = classroom.getGradeBook();
        System.out.println("Grade Book:");
        for (Map.Entry<Student, String> entry : gradeBook.entrySet()) {
            Student student = entry.getKey();
            String averageScore = entry.getValue();
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - Average Score: " + averageScore);
        }
    }
}

