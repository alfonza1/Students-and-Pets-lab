package io.zipcoder.gradedStudents;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    // Method implementations
    public double getExamScores() {
        double sum = 0.0;
        int count = examScores.size();
        for(int i = 0; i < count; i++) {
            sum += examScores.get(i);
        }
        return sum / count;
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0;
        for (Double score : examScores) {
            sum += score;
        }
        double average = sum / examScores.size();
        String formattedAverage = String.format("%.2f", average);
        return Double.parseDouble(formattedAverage);
    }



    public String toString() {
        return "Student Name: " + firstName + " " + lastName +
                "\n> Average Score: " + getAverageExamScore() +
                "\n> " + getExamScores();
    }
}

