package edu.westga.comp4420.lab01.model;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course course) {
		if (!this.courses.contains(course)) {
			return this.courses.add(course); 
		}
		return false;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public List<Course> getCoursesByDepartment(String departmentPrefix) {
        List<Course> departmentCourses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getPrefix().equals(departmentPrefix)) {
                departmentCourses.add(course);
            }
        }
        return departmentCourses;
    }

    public List<Course> getCoursesBySemester(String semester) {
        List<Course> semesterCourses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.getSemester().equals(semester)) {
                semesterCourses.add(course);
            }
        }
        return semesterCourses;
    }

    public String getMostRecentSemester() {
        String mostRecentSemester = "";
        for (Course course : this.courses) {
            if (course.getSemester().compareTo(mostRecentSemester) > 0) {
                mostRecentSemester = course.getSemester();
            }
        }
        return mostRecentSemester;
    }
}