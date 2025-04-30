package edu.westga.comp4420.lab02.test.model.grocery_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.lab02.model.GroceryItem;

class TestGroceryItemGettersSetters {

    @Test
    void testGetSetPrefix() {
        GroceryItem item = new GroceryItem("Bannanna");
        assertEquals("Bannanna", item.getItem(), "Prefix should be 'Bannanna'");
        item.setItem("Orange");
        assertEquals("Orange", item.getItem(), "Prefix should be updated to 'Orange'");
    }

 //   @Test
  //  void testGetSetNumber() {
 //      Course course = new Course("CS", 999, "Fall", "");
 //       assertEquals(999, course.getNumber(), "Number should be 999");
 //       course.setNumber(1001);
 //       assertEquals(1001, course.getNumber(), "Number should be updated to 1001");
 //   }

}
