import java.io.*;
public class Movie extends Product implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int length;
	private float rating;


	public Movie(int id, String title, int value, int length, float rating, boolean borrowed) {
		super();
		this.length = length;
		this.rating = rating;

	}

	public Movie(){
		super();
	}

	@Override
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
		return this.getClass().getSimpleName() + title + ": Value " + value + "kr, Length " + length + ", Rating " + rating;

	}

}
