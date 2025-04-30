package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab01.model.Course;
import edu.westga.comp4420.lab01.model.CourseManager;

import java.util.List;

class TestCourseManagerGetters {

    private CourseManager courseManager;

    @BeforeEach
    void setUp() {
        courseManager = new CourseManager();
    }

    @Test
    void testGetCourses() {
        Course course1 = new Course("CS", 101, "Fall", "");
        Course course2 = new Course("Math", 202, "Spring", "");
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        List<Course> courses = courseManager.getCourses();
        assertEquals(2, courses.size());
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }

    @Test
    void testGetCoursesByDepartment() {
        Course course1 = new Course("CS", 101, "Fall", "");
        Course course2 = new Course("Math", 202, "Spring", "");
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        List<Course> csCourses = courseManager.getCoursesByDepartment("CS");
        assertEquals(1, csCourses.size());
        assertTrue(csCourses.contains(course1));
        List<Course> mathCourses = courseManager.getCoursesByDepartment("Math");
        assertEquals(1, mathCourses.size());
        assertTrue(mathCourses.contains(course2));
    }

    @Test
    void testGetCoursesBySemester() {
        Course course1 = new Course("CS", 101, "Fall", "");
        Course course2 = new Course("Math", 202, "Spring", "");
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        List<Course> fallCourses = courseManager.getCoursesBySemester("Fall");
        assertEquals(1, fallCourses.size());
        assertTrue(fallCourses.contains(course1));
        List<Course> springCourses = courseManager.getCoursesBySemester("Spring");
        assertEquals(1, springCourses.size());
        assertTrue(springCourses.contains(course2));
    }

    @Test
    void testGetMostRecentSemester() {
        Course course1 = new Course("CS", 101, "Fall", "");
        Course course2 = new Course("Math", 202, "Spring", "");
        Course course3 = new Course("Physics", 303, "Winter", "");
        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        courseManager.addCourse(course3);
        String mostRecent = courseManager.getMostRecentSemester();
        assertEquals("Winter", mostRecent);
    }

@Test
void testGetMostRecentSemesterWithSameOrEarlierSemester() {
    Course course1 = new Course("CS", 101, "Fall", "");
    Course course2 = new Course("Math", 202, "Fall", "");
    courseManager.addCourse(course1);
    courseManager.addCourse(course2);
    String mostRecent = courseManager.getMostRecentSemester();
    assertEquals("Fall", mostRecent);
}

    @Test
    void testGetMostRecentSemesterWhenEmpty() {
        String mostRecent = courseManager.getMostRecentSemester();
        assertEquals("", mostRecent);
    }
}
