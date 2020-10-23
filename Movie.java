public class Movie {

	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int length;
	private float rating;


	public Movie(int id, String title, int value, int length, float rating) {
		this.id = id;
		this.title = title;
		this.value = value;
		this.length = length;
		this.rating = rating;
	}

	public Movie(){
		super();
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getRating() {
		return rating;
	}

	@Override      // Overshadowed the toString() method
	public String toString() {
		return  id + " (" + this.getClass().getSimpleName() + "): " + title + ". " + "(in stock)";
	}




	public void update(int length, float rating) {

	}

}
