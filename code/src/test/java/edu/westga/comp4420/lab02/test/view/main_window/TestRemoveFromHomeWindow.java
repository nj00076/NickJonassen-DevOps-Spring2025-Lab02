package edu.westga.comp4420.lab02.test.view.main_window;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import edu.westga.comp4420.lab02.model.GroceryItem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TestRemoveFromHomeWindow extends ApplicationTest {

    private ListView<GroceryItem> groceryItemList;
    private Button addButton;
    private Button removeButton;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab02/view/codebehind/HomeWindow.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

        this.groceryItemList = lookup("#groceryItemList").query();
        this.addButton = lookup("#addButton").query();
        this.removeButton = lookup("#removeButton").query();
    }

    @Test
    public void testRemoveItemFromList() {
        clickOn(addButton);
        clickOn("#groceryItemText").write("Apples");
        clickOn("#numberText").write("5");
        clickOn("#saveButton");
        interact(() -> groceryItemList.getSelectionModel().select(0));
        clickOn(removeButton);
        assertEquals(0, groceryItemList.getItems().size());
    }
	
	@Test
    public void testRemoveItemWhenNoItemSelected() {
		clickOn(addButton);
        clickOn("#groceryItemText").write("Apples");
        clickOn("#numberText").write("5");
        clickOn("#saveButton");
        groceryItemList.getSelectionModel().clearSelection();
        clickOn(removeButton);
        assertEquals(1, groceryItemList.getItems().size());
	}
}
