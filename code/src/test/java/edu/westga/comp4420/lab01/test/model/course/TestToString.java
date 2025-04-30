package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab01.model.Course;

class TestToString {

    @Test
    void testToStringNormal() {
        Course course = new Course("Math", 101, "Spring", "");
        String expected = "Math 101 - Spring";
        assertEquals(expected, course.toString(), "toString() should return the correct string representation");
    }
}
