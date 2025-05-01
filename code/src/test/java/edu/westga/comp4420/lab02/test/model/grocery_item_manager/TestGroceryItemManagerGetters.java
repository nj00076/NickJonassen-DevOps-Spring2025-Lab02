package edu.westga.comp4420.lab02.test.model.grocery_item_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;
import edu.westga.comp4420.lab02.model.GroceryItemManager;

import java.util.List;

class TestCourseManagerGetters {

    private GroceryItemManager groceryItemManager;
    
    @BeforeEach
    void setUp() {
        groceryItemManager = new GroceryItemManager(); 
    }

    @Test
    void testGetCourses() {
        GroceryItem item = new GroceryItem("MUG", 999);
        GroceryItem item2 = new GroceryItem("Code Red", 999);
        groceryItemManager.addItem(item);
        groceryItemManager.addItem(item2);
        List<GroceryItem> items = groceryItemManager.getGroceryItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(item));
        assertTrue(items.contains(item2));
    }
}
