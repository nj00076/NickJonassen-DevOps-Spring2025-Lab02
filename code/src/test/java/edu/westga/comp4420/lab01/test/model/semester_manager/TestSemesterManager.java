package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.westga.comp4420.lab01.model.SemesterManager;

class TestSemesterManager {
    
    private SemesterManager semesterManager;

    @BeforeEach
    void setUp() {
        semesterManager = new SemesterManager();
    }

    @Test
    void testAddSemester() {
        semesterManager.addSemester("Fall");
        List<String> semesters = semesterManager.getSemesters();
        assertEquals(1, semesters.size(), "There should be 1 semester in the list.");
        assertTrue(semesters.contains("Fall"), "The semester 'Fall' should be in the list.");
    }

    @Test
    void testAddMultipleSemesters() {
        semesterManager.addSemester("Fall");
        semesterManager.addSemester("Spring");
        List<String> semesters = semesterManager.getSemesters();
        assertEquals(2, semesters.size(), "There should be 2 semesters in the list.");
        assertTrue(semesters.contains("Fall"), "The semester 'Fall' should be in the list.");
        assertTrue(semesters.contains("Spring"), "The semester 'Spring' should be in the list.");
    }

    @Test
    void testGetSemestersEmpty() {
        List<String> semesters = semesterManager.getSemesters();
        assertTrue(semesters.isEmpty());
    }
}
