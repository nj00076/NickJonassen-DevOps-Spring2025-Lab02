package edu.westga.comp4420.lab02.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;

class TestToString {

    @Test
    void testToStringNormal() {
        GroceryItem item = new GroceryItem("Bannanna", 999);;
        String expected = "Item name - Bannanna / Quantity of Item - 999";
        assertEquals(expected, item.toString(), "toString() should return the correct string representation");
    }
}
