import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

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
		//Book bok2 = new Book(2, "The Island", 299, 233, "Huxley");
	//	allProducts.add(bok2);
	//	System.out.println(allProducts);
		Scanner sc = new Scanner(System.in);
		Book bok = new Book();
		System.out.println("Enter product ID: ");
		System.out.print("> ");
		bok.setId(sc.nextInt());
		// here our program can check in the file if the id is already exist

		Scanner st = new Scanner(System.in);
		System.out.println("Enter title: "  );
		System.out.print("> ");
		bok.setTitle(st.nextLine());
		//System.out.println(bok.getTitle());
		System.out.println("Enter Value: "  );
		System.out.print("> ");
		bok.setValue(sc.nextInt());
		//System.out.println(bok.getValue());
		System.out.println("Enter Pages: "  );
		System.out.print("> ");
		bok.setPages(sc.nextInt());
		//System.out.println(bok.getPages());
		System.out.println("Enter Publisher Name: "  );
		System.out.print("> ");
		Scanner sp = new Scanner(System.in);
		bok.setPublisher(sp.nextLine());
		//System.out.println(bok.getPublisher());
		//System.out.println(bok.toString());
		allProducts.add(bok);
		System.out.println(Arrays.asList(allProducts));

	}

	@Override
	public void deregister() {

	}
}