import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.GradeEvaluator;
import com.example.Student;

public class GradeEvaluatorTest {

    private GradeEvaluator gradeEvaluator;
    private Student mockStudent;

    @BeforeEach
    public void setUp() {
        gradeEvaluator = new GradeEvaluator();
        mockStudent = mock(Student.class);
    }

    @Test
    public void testEvaluatePerformance_Passed() {
        when(mockStudent.calculateAverage()).thenReturn(75.0);
        String result = gradeEvaluator.evaluatePerformance(mockStudent);
        assertEquals("Passed", result);
    }

    @Test
    public void testEvaluatePerformance_Failed() {
        when(mockStudent.calculateAverage()).thenReturn(50.0);
        String result = gradeEvaluator.evaluatePerformance(mockStudent);
        assertEquals("Failed", result);
    }

    @Test
    public void testEvaluatePerformance_Exception() {
        when(mockStudent.calculateAverage()).thenThrow(new RuntimeException());
        String result = gradeEvaluator.evaluatePerformance(mockStudent);
        assertEquals("Error in calculating performance", result);
    }

    @Test
    public void testEvaluatePerformance_NullStudent() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gradeEvaluator.evaluatePerformance(null);
        });
        assertEquals("Student cannot be null", exception.getMessage());
    }

    @Test
    public void testIsEligibleForHonors_True() {
        when(mockStudent.calculateAverage()).thenReturn(90.0);
        boolean result = gradeEvaluator.isEligibleForHonors(mockStudent);
        assertTrue(result);
    }

    @Test
    public void testIsEligibleForHonors_False() {
        when(mockStudent.calculateAverage()).thenReturn(80.0);
        boolean result = gradeEvaluator.isEligibleForHonors(mockStudent);
        assertFalse(result);
    }

    @Test
    public void testIsEligibleForHonors_Exception() {
        when(mockStudent.calculateAverage()).thenThrow(new RuntimeException());
        boolean result = gradeEvaluator.isEligibleForHonors(mockStudent);
        assertFalse(result);
    }

    @Test
    public void testIsEligibleForHonors_NullStudent() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gradeEvaluator.isEligibleForHonors(null);
        });
        assertEquals("Student cannot be null", exception.getMessage());
    }

    @Test
    public void testIsEligibleForHonors_NoGrades() {
        when(mockStudent.calculateAverage()).thenReturn(0.0);
        boolean result = gradeEvaluator.isEligibleForHonors(mockStudent);
        assertFalse(result);
    }

    @Test
    public void testIsEligibleForHonors_OneGrade() {
        when(mockStudent.calculateAverage()).thenReturn(95.0);
        boolean result = gradeEvaluator.isEligibleForHonors(mockStudent);
        assertTrue(result);
    }

   

}
