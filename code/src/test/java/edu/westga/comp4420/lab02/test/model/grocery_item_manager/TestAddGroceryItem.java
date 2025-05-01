package edu.westga.comp4420.lab02.test.model.grocery_item_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;
import edu.westga.comp4420.lab02.model.GroceryItemManager;
class TestAddCourse {

    private GroceryItemManager groceryItemManager;
    
    @BeforeEach
    void setUp() {
        groceryItemManager = new GroceryItemManager(); 
    }

    @Test
    void testAddNewGroceryItem() {
        GroceryItem item = new GroceryItem("MUG", 999);
        boolean result = groceryItemManager.addItem(item);
        assertTrue(result);
    }
	
	@Test
    void testAddDuplicateGroceryItem() {
        GroceryItem item = new GroceryItem("MUG", 999);
		groceryItemManager.addItem(item);
        boolean result = groceryItemManager.addItem(item);
        assertFalse(result);
    }

    @Test
    void testAddMultipleGroceryItems() {
        GroceryItem item = new GroceryItem("MUG", 999);
        GroceryItem item2 = new GroceryItem("Code Red", 999);
        boolean result1 = groceryItemManager.addItem(item);
        boolean result2 = groceryItemManager.addItem(item2);
        assertTrue(result1, "Item 1 should be added.");
        assertTrue(result2, "Item 2 should be added.");
    }
}
