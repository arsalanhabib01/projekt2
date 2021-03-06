import java.io.Serializable;

public class Book extends Product implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private final int type = 1;
	private int pages;
	private String publisher;
	private String CustomerName;
	private String CustomerPhoneNo;
/*
	public Book(int id, String title, int value, int pages, String publisher, boolean borrowed) {
		super();
		this.pages = pages;
		this.publisher = publisher;
		this.borrowed = borrowed; 
	}
*/
	public Book(){ super(); }

	public int getType(){return type;}

	@Override
	public void setCustomerName(String CustomerName){
		super.setCustomerName(CustomerName);
		this.CustomerName = CustomerName; }

	@Override
	public void setCustomerPhoneNo(String CustomerPhoneNo){
		super.setCustomerPhoneNo(CustomerPhoneNo);
		this.CustomerPhoneNo = CustomerPhoneNo; }

		public String getCustomerName(){return CustomerName;}

		public String getCustomerPhoneNo(){return CustomerPhoneNo;}

	@Override
	public void setBorrowed(boolean borrowed) {
		super.setBorrowed(borrowed);
		this.borrowed = borrowed; }

	public boolean getBorrowed() { return borrowed; }

	public void setId(int id) { this.id = id; }

	public int getId() { return id; }

	public void setTitle(String title) { this.title = title; }

	public String getTitle() { return title; }

	public void setValue(int value) { this.value = value; }

	public int getValue() { return value; }

	public void setPages(int pages) { this.pages = pages; }

	public int getPages() { return pages; }

	public void setPublisher(String publisher) { this.publisher = publisher; }

	public String getPublisher() { return publisher; }

	@Override      // Overshadowed the toString() method
	public String toString() {
		String isBorrowed = null;
		if (!this.getBorrowed())
			isBorrowed = "\n\tBorrowed by " + getCustomerName() + ", " + getCustomerPhoneNo();
		else if (this.getBorrowed())
			isBorrowed = "(in stock)";

		return  id + " (" + this.getClass().getSimpleName() + "): " + title + ". " + isBorrowed;
	}
}
