public class Book {

	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int pages;
	private String publisher;

	public Book(int id, String title, int value, int pages, String publisher) {
		this.id = id;
		this.title = title;
		this.value = value;
		this.pages = pages;
		this.publisher = publisher;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	//public void getId(){
	//	this.id = id;
	//}
	
	@Override      // Overshadowed the toString() method
	public String toString() {
		return  id + " (" + this.getClass().getSimpleName() + "): " + title + ". " + "(in stock)";
	}


	public void update(int pages, String publisher) {


	}

}
