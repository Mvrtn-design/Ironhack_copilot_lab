package com.example;

import java.util.List;

public class Student {
    private List<Double> grades;

    /**
     * Calculates the average of the student's grades.
     * 
     * @return the average grade as a double.
     * @throws IllegalArgumentException if the grades list is null, empty, or contains invalid grades.
     */
    public double calculateAverage() {
        // Check if grades list is null or empty
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("No grades available to calculate average");
        }

        double sum = 0.0;
        // Iterate through each grade in the list
        for (double grade : grades) {
            // Check if the grade is within the valid range (0 to 100)
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Invalid grade found: " + grade);
            }
            // Add the grade to the sum
            sum += grade;
        }

        // Calculate and return the average grade
        return sum / grades.size();
    }

    public void setGrades(List<Double> asList) {
        this.grades = asList;
    }

    // Other methods and constructors
}