package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab01.model.Course;

class TestHashCode {

    @Test
    void testHashCodeConsistency() {
        Course course = new Course("CS", 999, "Fall", "");
        int hashCode1 = course.hashCode();
        int hashCode2 = course.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void testHashCodeEquality() {
        Course course1 = new Course("CS", 999, "Fall", "");
        Course course2 = new Course("CS", 999, "Fall", "");
        assertTrue(course1.equals(course2), "Courses should be equal");
        assertEquals(course1.hashCode(), course2.hashCode());
    }

    @Test
    void testHashCodeInequality() {
        Course course1 = new Course("CS", 999, "Fall", "");
        Course course2 = new Course("Math", 1000, "Spring", "");
        assertFalse(course1.equals(course2), "Courses should not be equal");
        assertNotEquals(course1.hashCode(), course2.hashCode());
    }
}
