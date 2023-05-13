package io.zipcoder.gradedStudents;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];

    }

    public Classroom(Student[] students) {
        this.maxNumberOfStudents = students.length;
        this.students = students;
    }

    public Classroom() {
        this(30);
    }



    public double getAverageExamScore() {
        double sum = 0.0;
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                double examScore = students[i].getAverageExamScore();
                sum += examScore;
                count++;
            }
        }
        return sum / count;
    }



    public Student[] getStudents() {
        return students;
    }

    public Student[] addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
        return students;
    }

    public Student[] removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;

            } }


        return students;
    }



    public Student[] getStudentsByScore() {
        Student[] sortedStudents = Arrays.copyOf(students, students.length);
        Arrays.sort(sortedStudents, (a, b) -> {
            if (a == null) {
                return 1;
            } else if (b == null) {
                return -1;
            } else {
                int scoreComparison = Double.compare(b.getAverageExamScore(), a.getAverageExamScore());
                if (scoreComparison == 0) {
                    return a.getLastName().compareTo(b.getLastName());
                } else {
                    return scoreComparison;
                }
            }
        });
        return sortedStudents;
    }


    public Map<Student, String> getGradeBook() {
        Map<Student, String> gradeBook = new HashMap<>();

        for (Student student : students) {
            double averageScore = student.getAverageExamScore();
            gradeBook.put(student, String.valueOf(averageScore));
        }

        return gradeBook;
    }



}

