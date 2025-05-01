package edu.westga.comp4420.lab02.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import edu.westga.comp4420.lab02.model.GroceryItem;

public class GroceryItemInfoWindow {
    
    @FXML
    private Button cancelButton;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private TextField numberText;
    
    @FXML
    private TextField groceryItemText;

    private GroceryItem selectedItem;
    private HomeWindow homeWindow;

    public void setHomeWindow(HomeWindow homeWindow) {
        this.homeWindow = homeWindow;
    }

    @FXML
    void initialize() {
        this.cancelButton.setOnAction(event -> this.closeWindow());
        this.saveButton.setOnAction(event -> this.saveCourse());
    }

    public void populateFields(GroceryItem groceryItem) {
        this.selectedItem = groceryItem;
        this.groceryItemText.setText(groceryItem.getItem());
        this.numberText.setText(String.valueOf(groceryItem.getNumber()));
    }

    private void saveCourse() {
        String item = this.groceryItemText.getText();
        int number;
        try {
            number = Integer.parseInt(this.numberText.getText());
        } catch (NumberFormatException e) {
            this.showError("Course number must be an integer.");
            return;
        }
        if (item.isEmpty() || this.numberText.getText().isEmpty()) {
            this.showError("Item Name and Quantity are required fields.");
            return;
        }
		if (Integer.valueOf(this.numberText.getText()) < 0) {
            this.showError("Quantity cannot be negative.");
            return;
        }
        GroceryItem groceryItem = new GroceryItem(item, number);

        if (this.selectedItem == null) {
            this.homeWindow.setGroceryItemManager(groceryItem);
        } else {
            this.homeWindow.removeItem(this.selectedItem);
            this.homeWindow.setGroceryItemManager(groceryItem);
        }
        this.closeWindow();
        this.notifyHomeWindow();
    }

    private void notifyHomeWindow() {
        this.homeWindow.refreshGroceryItemList();
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
