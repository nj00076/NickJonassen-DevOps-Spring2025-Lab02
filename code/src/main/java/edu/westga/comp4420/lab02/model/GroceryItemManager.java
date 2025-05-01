package edu.westga.comp4420.lab02.model;

import java.util.ArrayList;
import java.util.List;

public class GroceryItemManager {

    private List<GroceryItem> items;

    public GroceryItemManager() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(GroceryItem item) {
		if (!this.items.contains(item)) {
			return this.items.add(item); 
		}
		return false;
    }

    public List<GroceryItem> getGroceryItems() {
        return this.items;
    }
	
	public boolean remove(GroceryItem item) {
		return this.items.remove(item);
	}

}