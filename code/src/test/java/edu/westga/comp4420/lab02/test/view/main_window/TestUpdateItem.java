package edu.westga.comp4420.lab02.test.view.main_window;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import edu.westga.comp4420.lab02.model.GroceryItem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class TestUpdateItem extends ApplicationTest {

    private ListView<GroceryItem> groceryItemList;
    private Button addButton;
    private Button updateButton;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab02/view/codebehind/HomeWindow.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();

        this.groceryItemList = lookup("#groceryItemList").query();
        this.addButton = lookup("#addButton").query();
        this.updateButton = lookup("#updateButton").query();
    }

    @Test
    public void testUpdateItemInList() {
        clickOn(addButton);
        clickOn("#groceryItemText").write("Bananas");
        clickOn("#numberText").write("5");
        clickOn("#saveButton");
        assertEquals(1, groceryItemList.getItems().size());
        assertEquals("Bananas", groceryItemList.getItems().get(0).getItem());
        assertEquals(5, groceryItemList.getItems().get(0).getNumber());
        interact(() -> groceryItemList.getSelectionModel().select(0));
        clickOn(updateButton);
        clickOn("#groceryItemText").write("Strawberries");
        clickOn("#numberText").write("10");
        clickOn("#saveButton");
        assertEquals(1, groceryItemList.getItems().size());
        assertEquals("BananasStrawberries", groceryItemList.getItems().get(0).getItem());
        assertEquals(510, groceryItemList.getItems().get(0).getNumber());
    }
	
	@Test
    public void testUpdateItemWhenNoItemSelected() {
		clickOn(addButton);
        clickOn("#groceryItemText").write("Apples");
        clickOn("#numberText").write("5");
        clickOn("#saveButton");
        groceryItemList.getSelectionModel().clearSelection();
        clickOn(updateButton);
        assertEquals(1, groceryItemList.getItems().size());
		assertEquals("Apples", groceryItemList.getItems().get(0).getItem());
        assertEquals(5, groceryItemList.getItems().get(0).getNumber());
	}
}
