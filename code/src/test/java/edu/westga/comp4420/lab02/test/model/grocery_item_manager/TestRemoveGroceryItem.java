package edu.westga.comp4420.lab02.test.model.grocery_item_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;
import edu.westga.comp4420.lab02.model.GroceryItemManager;
class TestRemoveCourse {

    private GroceryItemManager groceryItemManager;
    
    @BeforeEach
    void setUp() {
        groceryItemManager = new GroceryItemManager(); 
    }

    @Test
    void testAddRemoveGroceryItem() {
        GroceryItem item = new GroceryItem("MUG", 999);
		groceryItemManager.addItem(item);
        boolean result = groceryItemManager.remove(item);
        assertTrue(result);
    }
}
