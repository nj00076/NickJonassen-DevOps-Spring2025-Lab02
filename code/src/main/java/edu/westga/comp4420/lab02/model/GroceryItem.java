package edu.westga.comp4420.lab02.model;

import java.util.Objects;

public class GroceryItem {
    private String item;
   

    public GroceryItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

  //  @Override
  //  public boolean equals(Object obj) {
  //      if (this == obj) {
	//		return true;
//		}
  //      if (obj == null || getClass() != obj.getClass()) {
	//		return false;
	//	}
  //      Course course = (Course) obj;
  //      return this.number == course.number && this.prefix.equals(course.prefix) && this.semester.equals(course.semester);
  //  }

  //  @Override
  //  public int hashCode() {
  //      return Objects.hash(this.prefix, this.number, this.semester);
  //  }

   // @Override
  //  public String toString() {
  //      return this.prefix + " " + this.number + " - " + this.semester;
  //  }
}