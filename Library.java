import java.io.FileNotFoundException;

public class Library implements IntLib {

	//private Book[] books;
	//private Movie[] movies;
	private String productPath;

	public Library (String productPath) throws FileNotFoundException {
		this.productPath = productPath;
		//books = parseBooks(productPath);  //not sure if this is right
		//movies = parseMovies(productPath);
	}


	private boolean parseId(int id) {

		throw new UnsupportedOperationException();
	}


	public void writeProduct(int id) {

		throw new UnsupportedOperationException();
	}

	@Override
	public void register() {

	}

	@Override
	public void deregister() {

	}
}