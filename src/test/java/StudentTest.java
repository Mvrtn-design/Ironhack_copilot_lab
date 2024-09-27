import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Student;

import java.util.Arrays;
import java.util.Collections;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student();
    }

    @Test
    public void testCalculateAverageWithValidGrades() {
        student.setGrades(Arrays.asList(90.0, 80.0, 70.0));
        double average = student.calculateAverage();
        assertEquals(80.0, average, 0.001);
    }

    @Test
    public void testCalculateAverageWithEmptyGrades() {
        student.setGrades(Collections.emptyList());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.calculateAverage();
        });
        assertEquals("No grades available to calculate average", exception.getMessage());
    }

    @Test
    public void testCalculateAverageWithNullGrades() {
        student.setGrades(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.calculateAverage();
        });
        assertEquals("No grades available to calculate average", exception.getMessage());
    }

    @Test
    public void testCalculateAverageWithInvalidGrade() {
        student.setGrades(Arrays.asList(90.0, -10.0, 70.0));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.calculateAverage();
        });
        assertEquals("Invalid grade found: -10.0", exception.getMessage());
    }

    @Test
    public void testCalculateAverageWithSingleGrade() {
        student.setGrades(Arrays.asList(100.0));
        double average = student.calculateAverage();
        assertEquals(100.0, average, 0.001);
    }
}
