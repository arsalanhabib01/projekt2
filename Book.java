import java.io.Serializable;

public class Book extends Product implements Serializable {

	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int pages;
	private String publisher;

	public Book(int id, String title, int value, int pages, String publisher, boolean borrowed) {
		super();
		this.pages = pages;
		this.publisher = publisher;
		this.borrowed = borrowed; 
	}

	public Book(){
		super();
	}


	public void setBorrowed(boolean borrowed) {
		super.setBorrowed(borrowed);
		this.borrowed = borrowed;
	}

	public boolean getBorrowed() {
		return borrowed;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) { this.title = title; }

	public String getTitle() {
		return title;
	}

	public void setValue(int value) { this.value = value; }

	public int getValue() {
		return value;
	}

	public void setPages(int pages) { this.pages = pages; }

	public int getPages() {
		return pages;
	}

	public void setPublisher(String publisher) { this.publisher = publisher; }

	public String getPublisher() {
		return publisher;
	}

	@Override      // Overshadowed the toString() method
	public String toString() {
		String isBorrowed = null;
		if (!this.getBorrowed())  {
			isBorrowed = "(not available)";
		}
		else if (this.getBorrowed())  {
			isBorrowed = "(in stock)";
		}
		
		return  id + " (" + this.getClass().getSimpleName() + "): " + title + ". " + isBorrowed;
	}


	public String update() {
		return this.getClass().getSimpleName() + title + ": Value " + value + "kr, Pages " + pages + ", Publisher Name " + publisher;


	}

}
