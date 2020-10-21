public class Movie {

	private int id;
	private String title;
	private int value;
	private boolean borrowed;
	private int type;
	private int length;
	private float rating;

	/**
	 * 
	 * @param id
	 * @param title
	 * @param value
	 * @param borrowed
	 */
	public void product(int id, String title, int value, boolean borrowed) {
		// TODO - implement Movie.product
		this.id = id;
		this.title = title;
		this.value = value;
	}

	/**
	 * 
	 * @param length
	 * @param rating
	 */
	public void update(int length, float rating) {
		// TODO - implement Movie.update
		throw new UnsupportedOperationException();
	}

}
