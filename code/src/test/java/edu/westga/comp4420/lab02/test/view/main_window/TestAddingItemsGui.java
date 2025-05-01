package edu.westga.comp4420.lab02.test.view.main_window;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import edu.westga.comp4420.lab02.model.GroceryItem;
import edu.westga.comp4420.lab02.view.codebehind.GroceryItemInfoWindow;
import edu.westga.comp4420.lab02.view.codebehind.HomeWindow;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TestAddingItemsGui extends ApplicationTest {

    private GroceryItemInfoWindow controller;
    private TextField itemText;
    private TextField numberText;
    private Button saveButton;
    private boolean refreshCalled = false;
    private boolean itemAdded = false;
    private GroceryItem addedItem;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/westga/comp4420/lab02/view/codebehind/GroceryItemInfoWindow.fxml"));
        Scene scene = new Scene(loader.load());
        this.controller = loader.getController();
        HomeWindow mockHomeWindow = new HomeWindow() {
            @Override
            public void setGroceryItemManager(GroceryItem groceryItem) {
                itemAdded = true;
                addedItem = groceryItem;
            }
            @Override
            public void refreshGroceryItemList() {
                refreshCalled = true;
            }
            @Override
            public void removeItem(GroceryItem item) {
            }
        };
        controller.setHomeWindow(mockHomeWindow);
        stage.setScene(scene);
        stage.show();
        this.itemText = lookup("#groceryItemText").query();
        this.numberText = lookup("#numberText").query();
        this.saveButton = lookup("#saveButton").query();
    }

    @BeforeEach
    public void resetState() {
        refreshCalled = false;
        itemAdded = false;
        addedItem = null;
    }

    @Test
    public void testSaveValidItemAddsToManagerAndRefreshes() {
        clickOn(itemText).write("Milk");
        clickOn(numberText).write("3");
        clickOn(saveButton);
        assertTrue(itemAdded);
        assertNotNull(addedItem);
        assertEquals("Milk", addedItem.getItem());
        assertEquals(3, addedItem.getNumber());
        assertTrue(refreshCalled);
    }

    @Test
    public void testSaveWithEmptyFieldsShowsError() {
        clickOn(saveButton);
        assertFalse(itemAdded);
        assertFalse(refreshCalled);
    }

    @Test
    public void testSaveWithNonIntegerQuantityShowsError() {
        clickOn(itemText).write("Eggs");
        clickOn(numberText).write("abc");
        clickOn(saveButton);
        assertFalse(itemAdded);
        assertFalse(refreshCalled);
    }
	
	@Test
    public void testSaveWithNegativeQuantityShowsError() {
        clickOn(itemText).write("Eggs");
		clickOn(numberText).type(KeyCode.BACK_SPACE);
        write("-5");
        clickOn(saveButton);
        assertFalse(itemAdded);
        assertFalse(refreshCalled);
    }
	
	@Test
    public void testSaveWithEmptyItemShowsError() {
        clickOn(numberText).write("5");
        clickOn(saveButton);
        assertFalse(itemAdded);
        assertFalse(refreshCalled);
    }
	
	@Test
    public void testSaveWithEmptyIntegerQuantityShowsError() {
        clickOn(itemText).write("Eggs");
        clickOn(numberText);
		type(KeyCode.BACK_SPACE);
        clickOn(saveButton);
        assertFalse(itemAdded);
        assertFalse(refreshCalled);
    }
}
