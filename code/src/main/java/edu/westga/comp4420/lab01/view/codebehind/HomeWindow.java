package edu.westga.comp4420.lab01.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import edu.westga.comp4420.lab01.model.Course;
import edu.westga.comp4420.lab01.model.CourseManager;
import edu.westga.comp4420.lab01.model.DepartmentManager;
import edu.westga.comp4420.lab01.model.SemesterManager;

public class HomeWindow {
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button updateButton;
	
	@FXML
	private ListView<Course> allCourseList;
	
	@FXML
	private ListView<String> departmentListView;
	
	@FXML
	private ListView<String> semesterListView;
	
	private CourseManager courseManager;
	private DepartmentManager departmentManager;
	private SemesterManager semesterManager;
	
	public HomeWindow() {
		this.courseManager = new CourseManager();
		this.departmentManager = new DepartmentManager();
		this.semesterManager = new SemesterManager();
	}
	
	
	public void setCourseManager(Course course) {
		this.courseManager.addCourse(course);
		if (!this.departmentManager.getDepartments().contains(course.getPrefix())) {
			this.departmentManager.addDepartment(course.getPrefix());
		}
		if (!this.semesterManager.getSemesters().contains(course.getSemester())) {
			this.semesterManager.addSemester(course.getSemester());
		}
	}
	
	@FXML
	public void initialize() {
		this.refreshCourseList();
		this.populateDepartmentListView();
		this.addButton.setOnAction(event -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab01/view/codebehind/CourseInfoWindow.fxml"));
				Parent root = loader.load();
				CourseInfoWindow courseInfoWindow = loader.getController();
				courseInfoWindow.setHomeWindow(this);
				Stage stage = new Stage();
				stage.setTitle("Add Course");
				stage.setScene(new Scene(root));
				stage.show();
				stage.setOnHiding(e -> this.refreshCourseList());
			} catch (Exception e) {
				e.printStackTrace();
				this.showError("Error opening Course Information Window");
			}
		});
		this.initializeUpdate();
	}
	
	private void populateDepartmentListView() {
		this.departmentListView.getItems().clear();
		this.departmentListView.getItems().addAll(this.departmentManager.getDepartments());
		if (!this.departmentListView.getItems().isEmpty()) {
			this.departmentListView.getSelectionModel().selectFirst();
			this.filterCoursesByDepartment(this.departmentListView.getSelectionModel().getSelectedItem());
		}
		this.departmentListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				this.filterCoursesByDepartment(newValue);
			}
		});
	}
	
	private void filterCoursesByDepartment(String department) {
		this.allCourseList.getItems().clear();
		for (Course course : this.courseManager.getCourses()) {
			if (course.getPrefix().equals(department)) {
				this.allCourseList.getItems().add(course);
			}
		}
	}
	
	private void populateSemesterListView() {
		this.semesterListView.getItems().clear();
		this.semesterListView.getItems().addAll(this.semesterManager.getSemesters());
		if (!this.semesterListView.getItems().isEmpty()) {
			this.semesterListView.getSelectionModel().selectFirst();
			this.filterCoursesBySemester(this.semesterListView.getSelectionModel().getSelectedItem());
		}
		this.semesterListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				this.filterCoursesBySemester(newValue);
			}
		});
	}
	
	private void filterCoursesBySemester(String semester) {
		this.allCourseList.getItems().clear();
		for (Course course : this.courseManager.getCourses()) {
			if (course.getSemester().equals(semester)) {
				this.allCourseList.getItems().add(course);
			}
		}
	}
	
	private void initializeUpdate() {
		this.updateButton.setOnAction(event -> {
			Course selectedCourse = this.allCourseList.getSelectionModel().getSelectedItem();
			if (selectedCourse != null) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab01/view/codebehind/CourseInfoWindow.fxml"));
					Parent root = loader.load();
					CourseInfoWindow courseInfoWindow = loader.getController();
					courseInfoWindow.populateFields(selectedCourse);
					Stage stage = new Stage();
					stage.setTitle("Update Course");
					stage.setScene(new Scene(root));
					stage.show();
					stage.setOnHiding(e -> this.refreshCourseList());
					this.refreshCourseList();
				} catch (Exception e) {
					e.printStackTrace();
					this.showError("Error opening Course Information Window");
				}
			} else {
				this.showError("Please select a course to update");
			}
		});
	}
	
	public void refreshCourseList() {
		this.allCourseList.getItems().clear();
		this.allCourseList.getItems().addAll(this.courseManager.getCourses());
		this.populateDepartmentListView();
		this.populateSemesterListView();
	}
	
	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}