import java.io.*;
public class Movie extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private final int type = 0;
	private int length;
	private float rating;
	private String CustomerName;
	private String CustomerPhoneNo;

/*
	public Movie(int id, String title, int value, int length, float rating, boolean borrowed) {
		super();
		this.length = length;
		this.rating = rating;

	}
*/
	public Movie(){ super(); }

	public int getType(){return type;}
	@Override
	public void setCustomerName(String CustomerName){
		super.setCustomerName(CustomerName);
		this.CustomerName = CustomerName;
	}

	@Override
	public void setCustomerPhoneNo(String CustomerPhoneNo){
		super.setCustomerPhoneNo(CustomerPhoneNo);
		this.CustomerPhoneNo = CustomerPhoneNo; }

	@Override
	public void setBorrowed(boolean borrowed) {
		super.setBorrowed(borrowed);
		this.borrowed = borrowed; }

	public String getCustomerName(){return CustomerName;}

	public String getCustomerPhoneNo(){return CustomerPhoneNo;}

	public boolean getBorrowed() { return borrowed; }


	public void setId(int id) { this.id = id; }

	public int getId() { return id; }

	public void setTitle(String title) { this.title = title; }

	public String getTitle() { return title; }

	public void setValue(int value) { this.value = value; }

	public int getValue() { return value; }

	public void setLength(int length) { this.length = length; }

	public int getLength() {return length;}

	public void setRating(float rating) { this.rating = rating; }

	public float getRating() {return rating;}

	@Override      // Overshadowed the toString() method
	public String toString() {
		String isBorrowed = null;
		if (!this.getBorrowed())
			isBorrowed = "\n\tBorrowed by: " + getCustomerName() + ", " + getCustomerPhoneNo();
		else if (this.getBorrowed())
			isBorrowed = "(in stock)";
		
		return  id + " (" + this.getClass().getSimpleName() + "): " + title + ". " + isBorrowed;
	}

}
