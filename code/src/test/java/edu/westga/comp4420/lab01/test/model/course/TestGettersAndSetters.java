package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab01.model.Course;

class TestCourseGettersSetters {

    @Test
    void testGetSetPrefix() {
        Course course = new Course("CS", 999, "Fall", "");
        assertEquals("CS", course.getPrefix(), "Prefix should be 'CS'");
        course.setPrefix("Math");
        assertEquals("Math", course.getPrefix(), "Prefix should be updated to 'Math'");
    }

    @Test
    void testGetSetNumber() {
        Course course = new Course("CS", 999, "Fall", "");
        assertEquals(999, course.getNumber(), "Number should be 999");
        course.setNumber(1001);
        assertEquals(1001, course.getNumber(), "Number should be updated to 1001");
    }

    @Test
    void testGetSetSemester() {
        Course course = new Course("CS", 999, "Fall", "");
        assertEquals("Fall", course.getSemester(), "Semester should be 'Fall'");
        course.setSemester("Spring");
        assertEquals("Spring", course.getSemester(), "Semester should be updated to 'Spring'");
    }

    @Test
    void testGetSetNotes() {
        Course course = new Course("CS", 999, "Fall", "");
        assertEquals("", course.getNotes(), "Notes should be empty initially");
        course.setNotes("This is a note.");
        assertEquals("This is a note.", course.getNotes(), "Notes should be updated to 'This is a note.'");
    }
}
