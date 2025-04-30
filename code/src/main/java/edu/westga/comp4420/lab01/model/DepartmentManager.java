package edu.westga.comp4420.lab01.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {
    private List<String> departments;

    public DepartmentManager() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentPrefix) {
        this.departments.add(departmentPrefix);
    }

    public List<String> getDepartments() {
        return this.departments;
    }
}