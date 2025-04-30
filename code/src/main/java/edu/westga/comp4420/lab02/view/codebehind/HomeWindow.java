package edu.westga.comp4420.lab02.view.codebehind;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import edu.westga.comp4420.lab02.model.GroceryItem;
import edu.westga.comp4420.lab02.model.GroceryItemManager;

public class HomeWindow {
	
	@FXML
	private Button addButton;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private Button updateButton;
	
	@FXML
	private ListView<GroceryItem> groceryItemList;
	
	private GroceryItemManager groceryItemManager;
	
	public HomeWindow() {
		this.groceryItemManager = new GroceryItemManager();
	}

	
	public void setGroceryItemManager(GroceryItem groceryItem) {
		this.groceryItemManager.addItem(groceryItem);
	}
	
	@FXML
	public void initialize() {
		this.refreshGroceryItemList();
		this.addButton.setOnAction(event -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab02/view/codebehind/GroceryItemInfoWindow.fxml"));
				Parent root = loader.load();
				GroceryItemInfoWindow groceryItemInfoWindow = loader.getController();
				groceryItemInfoWindow.setHomeWindow(this);
				Stage stage = new Stage();
				stage.setTitle("Grocery Manager");
				stage.setScene(new Scene(root));
				stage.show();
				stage.setOnHiding(e -> this.refreshGroceryItemList());
			} catch (Exception e) {
				e.printStackTrace();
				this.showError("Error opening Grocery Item Information Window");
			}
		});
		this.initializeUpdate();
		this.initializeRemove();
	}
	
	private void initializeRemove() {
		this.removeButton.setOnAction(event -> {
			GroceryItem selectedItem = this.groceryItemList.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				try {
					this.groceryItemManager.remove(selectedItem);
					this.refreshGroceryItemList();
				} catch (Exception e) {
					e.printStackTrace();
					this.showError("Error opening Grocery Item Information Window");
				}
			} else {
				this.showError("Please select a Grocery Item to remove");
			}
		});
	}
	
	private void initializeUpdate() {
		this.updateButton.setOnAction(event -> {
			GroceryItem selectedItem = this.groceryItemList.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab02/view/codebehind/GroceryItemInfoWindow.fxml"));
					Parent root = loader.load();
					GroceryItemInfoWindow groceryItemInfoWindow = loader.getController();
					groceryItemInfoWindow.populateFields(selectedItem);
					Stage stage = new Stage();
					stage.setTitle("Update Item");
					stage.setScene(new Scene(root));
					stage.show();
					stage.setOnHiding(e -> this.refreshGroceryItemList());
					this.refreshGroceryItemList();
				} catch (Exception e) {
					e.printStackTrace();
					this.showError("Error opening Grocery Item Information Window");
				}
			} else {
				this.showError("Please select a Grocery Item to update");
			}
		});
	}
	
	public void refreshGroceryItemList() {
		this.groceryItemList.getItems().clear();
		this.groceryItemList.getItems().addAll(this.groceryItemManager.getGroceryItems());
	}
	
	private void showError(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}