package edu.westga.comp4420.lab01.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import edu.westga.comp4420.lab01.model.Course;
import edu.westga.comp4420.lab01.model.CourseManager;

public class CourseInfoWindow {
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private TextField numberText;
	
	@FXML
	private TextField prefixText;
	
	@FXML
	private TextField semesterText;
	
	@FXML
	private TextField notesText;
	
	@FXML
	private ListView<String> departmentListView;

	private CourseManager courseManager;
	private Course selectedCourse;
	private HomeWindow homeWindow;

	public CourseInfoWindow() {
		this.courseManager = new CourseManager();
	}
	
	public void setHomeWindow(HomeWindow homeWindow) {
		this.homeWindow = homeWindow;
	}
	
	@FXML
	void initialize() {
		this.cancelButton.setOnAction(event -> this.closeWindow());
		this.saveButton.setOnAction(event -> this.saveCourse());
	}
	
	
	public void populateFields(Course course) {
		this.selectedCourse = course;
		this.prefixText.setText(course.getPrefix());
		this.numberText.setText(String.valueOf(course.getNumber()));
		this.semesterText.setText(course.getSemester());
		this.notesText.setText(course.getNotes());
	}
	
	private void saveCourse() {
		String prefix = this.prefixText.getText();
		int number;
		String semester = this.semesterText.getText();
		String notes = this.notesText.getText();
		try {
			number = Integer.parseInt(this.numberText.getText());
		} catch (NumberFormatException e) {
			this.showError("Course number must be an integer.");
			return;
		}
		if (prefix == null || semester.isEmpty() || this.numberText.getText().isEmpty()) {
			this.showError("Prefix, Number, and Semester are required fields.");
			return;
		}
		Course newCourse = new Course(prefix, number, semester, notes);
		if (this.selectedCourse == null) {
			if (this.courseManager.addCourse(newCourse)) {
				this.closeWindow();
				this.homeWindow.setCourseManager(newCourse);
				this.notifyHomeWindow();
			} else {
				this.showError("Course already exists.");
			}
		} else {
			this.selectedCourse.setNotes(notes);
			this.closeWindow();
			this.notifyHomeWindow();
		}
	}
	
	private void notifyHomeWindow() {
		if (this.homeWindow != null) {
			this.homeWindow.refreshCourseList();
		}
	}
	
	private void closeWindow() {
		Stage stage = (Stage) this.saveButton.getScene().getWindow();
		stage.close();
	}
	
	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}