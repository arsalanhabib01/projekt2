import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

public class Library implements IntLib {

	LinkedList<Object> allProducts = new LinkedList<Object>(Arrays.asList()); //working on this

	//private Book[] books;
	//private Movie[] movies;
	private String libPath;

	public Library (String libPath) throws FileNotFoundException {

		this.libPath = libPath;
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
		Book bok2 = new Book(2, "The Island", 299, 233, "Huxley");
		allProducts.add(bok2);
		System.out.println(allProducts);
	}

	@Override
	public void deregister() {

	}
}