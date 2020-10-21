public class Book {

	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int pages;
	private String publisher;

	/**
	 * 
	 * @param id
	 * @param title
	 * @param value
	 * @param borrowed
	 */
	public void product(int id, String title, int value, boolean borrowed) {
		this.id = id;
		this.title = title;
		this.value = value;
	}

	/**
	 * 
	 * @param pages
	 * @param publisher
	 */
	public void update(int pages, String publisher) {
		// TODO - implement Book.update
		throw new UnsupportedOperationException();
	}

}
