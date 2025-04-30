package edu.westga.comp4420.lab01.model;

import java.util.ArrayList;
import java.util.List;

public class SemesterManager {
    private List<String> semesters;

    public SemesterManager() {
        this.semesters = new ArrayList<>();
    }

    public void addSemester(String semester) {
        this.semesters.add(semester);
    }

    public List<String> getSemesters() {
        return this.semesters;
    }
}