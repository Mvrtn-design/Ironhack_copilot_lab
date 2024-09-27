package com.example;

public class GradeEvaluator {
    private static final double PASSING_GRADE = 60.0;
    private static final double HONORS_GRADE = 85.0;

    /**
     * Evaluates the performance of a student based on their average grade.
     * 
     * @param student the student whose performance is to be evaluated.
     * @return "Passed" if the student's average grade is greater than or equal to
     *         the passing grade,
     *         "Failed" if it is below the passing grade, or "Error in calculating
     *         performance" if an exception occurs.
     * @throws IllegalArgumentException if the student is null.
     */
    public String evaluatePerformance(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        try {
            double averageGrade = student.calculateAverage();
            if (averageGrade >= PASSING_GRADE) {
                return "Passed";
            } else {
                return "Failed";
            }
        } catch (Exception e) {
            // Handle exception appropriately
            return "Error in calculating performance";
        }
    }

    /**
     * Determines if a student is eligible for honors based on their average grade.
     * 
     * @param student the student whose eligibility for honors is to be determined.
     * @return true if the student's average grade is greater than or equal to the
     *         honors grade,
     *         false otherwise or if an exception occurs.
     * @throws IllegalArgumentException if the student is null.
     */
    public boolean isEligibleForHonors(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        try {
            double averageGrade = student.calculateAverage();
            return averageGrade >= HONORS_GRADE;
        } catch (Exception e) {
            // Handle exception appropriately
            return false;
        }
    }
}