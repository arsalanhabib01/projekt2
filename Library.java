import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
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

		if (LibraryManager.isBook()) {

			//Book bok2 = new Book(2, "The Island", 299, 233, "Huxley");
			//	allProducts.add(bok2);
			//	System.out.println(allProducts);
			Scanner sc = new Scanner(System.in);
			Book bok = new Book();

			try{
			System.out.println("Enter product ID: ");
			System.out.print("> ");
			bok.setId(sc.nextInt());
			// here our program can check in the file if the id is already exist

			Scanner st = new Scanner(System.in);
			System.out.println("Enter Title: ");
			System.out.print("> ");
			bok.setTitle(st.nextLine());
			//System.out.println(bok.getTitle());
			System.out.println("Enter Value: ");
			System.out.print("> ");
			bok.setValue(sc.nextInt());
			//System.out.println(bok.getValue());
			System.out.println("Enter Pages: ");
			System.out.print("> ");
			bok.setPages(sc.nextInt());
			//System.out.println(bok.getPages());
			System.out.println("Enter Publisher Name: ");
			System.out.print("> ");
			Scanner sp = new Scanner(System.in);
			bok.setPublisher(sp.nextLine());
			//System.out.println(bok.getPublisher());
			//System.out.println(bok.toString());
			allProducts.add(bok);
			System.out.println(Arrays.asList(allProducts));
			writeRecord(bok);

			} catch (InputMismatchException e){
				System.out.println("Invalid Input : "+e);
				System.out.println("Register the Book Again :");
				register();
			}
		}

		else if (LibraryManager.isMovie()) {

			//Book bok2 = new Book(2, "The Island", 299, 233, "Huxley");
			//	allProducts.add(bok2);
			//	System.out.println(allProducts);
			Scanner sc = new Scanner(System.in);
			Movie movie = new Movie();
			try{
			System.out.println("Enter product ID: ");
			System.out.print("> ");
			movie.setId(sc.nextInt());

			// here our program can check in the file if the id is already exist

			Scanner st = new Scanner(System.in);
			System.out.println("Enter Title: ");
			System.out.print("> ");
			movie.setTitle(st.nextLine());
			//System.out.println(bok.getTitle());
			System.out.println("Enter Value: ");
			System.out.print("> ");
			movie.setValue(sc.nextInt());
			//System.out.println(bok.getValue());
			System.out.println("Enter Length: ");
			System.out.print("> ");
			movie.setLength(sc.nextInt());
			//System.out.println(bok.getPages());
			System.out.println("Enter IMDB rating: ");
			System.out.print("> ");
			Scanner sp = new Scanner(System.in);
			movie.setRating(sp.nextFloat());
			//System.out.println(bok.getPublisher());
			//System.out.println(bok.toString());
			allProducts.add(movie);
			System.out.println(Arrays.asList(allProducts));
			writeRecord(movie);

			} catch (InputMismatchException e){
				System.out.println("Invalid Input : "+e);
				System.out.println("Register the Movie Again :");
				register();
			}
		}


	}
	public void writeRecord(Object object){//LinkedList<Object> allProducts ){

		try{
			FileOutputStream fos = new FileOutputStream(libPath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//Movie movie = new Movie();
			//LinkedList object= allProducts;
			oos.writeObject(object);
			fos.flush();
			oos.flush();
		}catch (FileNotFoundException e){
			System.out.println(e);
		}catch (IOException e){
			System.out.println(e);
		}
		//objFilePath ="mySerializedlibrary.bin";
		try {
			FileInputStream fin = new FileInputStream(libPath);
			ObjectInputStream oin = new ObjectInputStream(fin);

			Object object1 = oin.readObject();
			fin.close();
			oin.close();
			System.out.println(object1.toString());
		}catch (FileNotFoundException e){
			System.out.println(e);
		}catch (IOException e){
			System.out.println(e);
		}catch (ClassNotFoundException e){
			System.out.println(e);
		}
	}

	@Override
	public void deregister() {
		writeRecord(allProducts);
	}

	@Override
	public void list() {
		writeRecord(allProducts);
		//System.out.println(allProducts);
	}

	@Override
	public void info(){
		writeRecord(allProducts);
	}
}