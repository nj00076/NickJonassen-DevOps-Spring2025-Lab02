package edu.westga.comp4420.lab01.model;

import java.util.Objects;

public class Course {
    private String prefix;
    private int number;
    private String semester;
    private String notes;

    public Course(String prefix, int number, String semester, String notes) {
        this.prefix = prefix;
        this.number = number;
        this.semester = semester;
        this.notes = notes;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        Course course = (Course) obj;
        return this.number == course.number && this.prefix.equals(course.prefix) && this.semester.equals(course.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.prefix, this.number, this.semester);
    }

    @Override
    public String toString() {
        return this.prefix + " " + this.number + " - " + this.semester;
    }
}