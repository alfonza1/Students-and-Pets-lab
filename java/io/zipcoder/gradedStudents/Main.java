package io.zipcoder.gradedStudents;


import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Classroom classroom = new Classroom(3);


        Double[] examScores1 = {100.0, 90.0, 95.0};
        Student student1 = new Student("Alfonza", "Jones", examScores1);

        Double[] examScores2 = {80.0, 85.0, 90.0};
        Student student2 = new Student("Aubrey", "Graham", examScores2);

        Double[] examScores3 = {75.0, 85.0, 70.0};
        Student student3 = new Student("Neil", "Degrasse Tyson", examScores3);


        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        // getting all students in the classroom
        Student[] students = classroom.getStudents();
        System.out.println("Students in the classroom:");
        for (Student student : students) {

            System.out.println(student.getFirstName() + " " + student.getLastName());

        }

        // getting the average exam score for the classroom
        double classAverage = classroom.getAverageExamScore();
        System.out.println("Class average exam score: " + classAverage);

        // getting the students sorted by score
        Student[] studentsByScore = classroom.getStudentsByScore();
        System.out.println("\nStudents sorted by score:");
        for (Student student : studentsByScore) {

            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - Average Score: " + student.getAverageExamScore());

        }

        // getting the grade book for the classroom
        Map<Student, String> gradeBook = classroom.getGradeBook();
        System.out.println("\nGrade Book:");
        for (Map.Entry<Student, String> entry : gradeBook.entrySet()) {
            Student student = entry.getKey();
            String averageScore = entry.getValue();
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    " - Average Score: " + averageScore);
        }
    }
}

