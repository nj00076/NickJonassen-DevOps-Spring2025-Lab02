package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab01.model.Course;
import edu.westga.comp4420.lab01.model.CourseManager;
class TestAddCourse {

    private CourseManager courseManager;
    
    @BeforeEach
    void setUp() {
        courseManager = new CourseManager(); 
    }

    @Test
    void testAddNewCourse() {
        Course course = new Course("CS", 999, "Fall", "");
        boolean result = courseManager.addCourse(course);
        assertTrue(result);
    }

    @Test
    void testAddDuplicateCourse() {
        Course course = new Course("CS", 999, "Fall", "");
        courseManager.addCourse(course);
        boolean result = courseManager.addCourse(course);
        assertFalse(result);
    }

    @Test
    void testAddMultipleCourses() {
        Course course1 = new Course("CS", 101, "Fall", "");
        Course course2 = new Course("Math", 201, "Spring", "");
        boolean result1 = courseManager.addCourse(course1);
        boolean result2 = courseManager.addCourse(course2);
        assertTrue(result1, "Course 1 should be added.");
        assertTrue(result2, "Course 2 should be added.");
    }
}
