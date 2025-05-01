package edu.westga.comp4420.lab02.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;

class TestGroceryItemGettersSetters {

    @Test
    void testGetSetPrefix() {
        GroceryItem item = new GroceryItem("Bannanna", 2);
        assertEquals("Bannanna", item.getItem(), "Prefix should be 'Bannanna'");
        item.setItem("Orange");
        assertEquals("Orange", item.getItem(), "Prefix should be updated to 'Orange'");
    }

    @Test
    void testGetSetNumber() {
        GroceryItem item = new GroceryItem("Bannanna", 999);
        assertEquals(999, item.getNumber(), "Number should be 999");
        item.setNumber(1001);
        assertEquals(1001, item.getNumber(), "Number should be updated to 1001");
    }

}
