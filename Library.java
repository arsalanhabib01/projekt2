import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Library implements IntLib {

	LinkedList<Product> allProducts = new LinkedList<Product>(Arrays.asList()); //working on this

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
		int count = 0;
		if (LibraryManager.isBook()) {

			Scanner sc = new Scanner(System.in);
			Product bok = new Book();

			try{
				do {
					if (count == 1) {
						System.out.println("Invalid ID: negative number");
						System.out.println("Re-Enter product ID: ");
						System.out.print("> ");
						((Book) bok).setId(sc.nextInt());
					}
					else {
						System.out.println("Enter product ID: ");
						System.out.print("> ");
						((Book) bok).setId(sc.nextInt());
						count = 1;
					}
				}while(bok.getId() < 0);
				// here our program can check in the file if the id is already exist
				count = 0;
				Scanner st = new Scanner(System.in);

				System.out.println("Enter Title: ");
				System.out.print("> ");
				((Book) bok).setTitle(st.nextLine());

				//System.out.println(bok.getTitle());
				System.out.println("Enter Value: ");
				System.out.print("> ");
				((Book) bok).setValue(sc.nextInt());
				//System.out.println(bok.getValue());
				System.out.println("Enter Pages: ");
				System.out.print("> ");
				((Book) bok).setPages(sc.nextInt());
				//System.out.println(bok.getPages());
				System.out.println("Enter Publisher Name: ");
				System.out.print("> ");
				Scanner sp = new Scanner(System.in);
				((Book) bok).setPublisher(sp.nextLine());
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

			Scanner sc = new Scanner(System.in);
			Product movie = new Movie();
			try{

				do {
					if (count == 1) {
						System.out.println("Invalid ID: negative number");
						System.out.println("Re-Enter product ID: ");
						System.out.print("> ");
						((Movie) movie).setId(sc.nextInt());
					}
					else {
						System.out.println("Enter product ID: ");
						System.out.print("> ");
						((Movie) movie).setId(sc.nextInt());
						count = 1;
					}
				}while(movie.getId() < 0);
				count = 0;
				// here our program can check in the file if the id is already exist

				Scanner st = new Scanner(System.in);
				System.out.println("Enter Title: ");
				System.out.print("> ");
				((Movie) movie).setTitle(st.nextLine());
				//System.out.println(bok.getTitle());
				System.out.println("Enter Value: ");
				System.out.print("> ");
				((Movie) movie).setValue(sc.nextInt());
				//System.out.println(bok.getValue());
				System.out.println("Enter Length: ");
				System.out.print("> ");
				((Movie) movie).setLength(sc.nextInt());
				//System.out.println(bok.getPages());

				Scanner sp = new Scanner(System.in);
				float fnumber;
				do {
					if (count == 1) {
						System.out.println("Invalid : Rating Range (0 - 10)  ");
						System.out.println("Re-Enter IMDB rating: ");
						System.out.print("> ");
						fnumber = sp.nextFloat();
						((Movie) movie).setRating(fnumber);
					}
					else {
						System.out.println("Enter IMDB rating: ");
						System.out.print("> ");
						fnumber = sp.nextFloat();
						((Movie) movie).setRating(fnumber);
						count = 1;
					}
				}while (fnumber < 0.0 || fnumber > 10.0);
				count = 0;

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

	public void writeRecord(Product product){//LinkedList<Object> allProducts ){

		try{
			FileOutputStream fos = new FileOutputStream(libPath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//Movie movie = new Movie();
			//LinkedList object= allProducts;
			oos.writeObject(product);
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
	public void deregister(String[] argument) {
		int input = Integer.parseInt(argument[0]);
		for (int i = 0; i < allProducts.size(); i++) {
			if(input == allProducts.get(i).getId()) {
				//need to show the title here
				System.out.println("Successfully deregistered " +allProducts.get(i).getId());
				allProducts.remove(i);
				break;
			}
			else
				System.out.println("Error: No product with id "+argument[0]+" registered.");
		}


	}

	@Override
	public void list() {
		for (int i = 0; i<allProducts.size(); i++) {
			System.out.println(allProducts.get(i) + "has ID: " + allProducts.get(0).getId());
		}
	}

	@Override
	public void info(String[] argument) {
		int input = Integer.parseInt(argument[0]);
		for (int i = 0; i < allProducts.size(); i++) {
			if(input == allProducts.get(i).getId()) {
				//need to show the update method here
				System.out.println(allProducts.get(i).toString());
				//allProducts.remove(i);
			}
			else
				System.out.println("Error: No product with id "+argument[0]+" registered.");
		}

		}
}