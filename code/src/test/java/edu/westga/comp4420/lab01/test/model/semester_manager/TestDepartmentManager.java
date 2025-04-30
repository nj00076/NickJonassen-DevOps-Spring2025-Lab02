package edu.westga.comp4420.lab01.test.model.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.westga.comp4420.lab01.model.DepartmentManager;

class TestCourseManager {

    private DepartmentManager departmentManager;

    @BeforeEach
    void setUp() {
        departmentManager = new DepartmentManager();
    }

    @Test
    void testAddDepartment() {
        departmentManager.addDepartment("CS");
        List<String> departments = departmentManager.getDepartments();
        assertEquals(1, departments.size());
        assertTrue(departments.contains("CS"));
    }

    @Test
    void testAddMultipleDepartments() {
        departmentManager.addDepartment("CS");
        departmentManager.addDepartment("Math");
        List<String> departments = departmentManager.getDepartments();
        assertEquals(2, departments.size());
        assertTrue(departments.contains("CS"));
        assertTrue(departments.contains("Math"));
    }

    @Test
    void testGetDepartmentsEmpty() {
        List<String> departments = departmentManager.getDepartments();
        assertTrue(departments.isEmpty());
    }
}
