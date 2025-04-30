package edu.westga.comp4420.lab02.model;

// import java.util.Objects;

public class GroceryItem {
    private String item;
	private int number;
   

    public GroceryItem(String item, int number) {
        this.item = item;
		this.number = number;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }
	
	public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "Item name - " + this.item + " / Quantity of Item - " + String.valueOf(this.number);
    }
}