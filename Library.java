import java.io.*;
import java.util.*;

public class Library implements IntLib {

	LinkedList<Product> allProducts = new LinkedList<Product>(Arrays.asList()); //working on this

	private final String libPath;

	public Library (String libPath) throws FileNotFoundException { this.libPath = libPath; }

	@Override
	public void init() {
		try {
			FileInputStream fin = new FileInputStream(libPath);
			ObjectInputStream oin = new ObjectInputStream(fin);

			for ( ;; )
				allProducts.add((Product) oin.readObject());


		}catch (FileNotFoundException e){
			System.out.println("ERROR: File Not Found Exception");
		}catch (EOFException e) {
			System.out.println("ID   " + "TYPE   " + "NAME   " + "STATE");
		} catch (IOException e) {
			System.out.println("ERROR: IO Exception");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Class Not Found Exception");
			e.printStackTrace();
		}
	}
	
	@Override
	public void register() {
		int count = 0;
		int id_count = 0;

		if (LibraryManager.isBook()) {

			Scanner sc = new Scanner(System.in);
			Book bok = new Book();

			try{
				do {
					if (count == 1) {
						System.out.println("Invalid ID: negative number");
						System.out.println("Re-Enter product ID: ");
						System.out.print("> ");
						bok.setId(sc.nextInt());
					}
					else {
						System.out.println("Enter product ID: ");
						System.out.print("> ");
						bok.setId(sc.nextInt());
						count = 1;}
				}while(bok.getId() < 0);
				count = 0;
				Scanner st = new Scanner(System.in);

				System.out.println("Enter Title: ");
				System.out.print("> ");
				bok.setTitle(st.nextLine());
				do {
					if (count == 1) {
						System.out.println("Invalid value: negative number");
						System.out.println("Re-Enter value: ");
						System.out.print("> ");
						bok.setValue(sc.nextInt());
					}
					else {
						System.out.println("Enter Value: ");
						System.out.print("> ");
						bok.setValue(sc.nextInt());
						count = 1;}
				}while(bok.getValue() < 0);
				count = 0;


				do {
					if (count == 1) {
						System.out.println("Invalid page number: negative number");
						System.out.println("Re-Enter page numbers: ");
						System.out.print("> ");
						bok.setPages(sc.nextInt());
					}
					else {
						System.out.println("Enter page numbers: ");
						System.out.print("> ");
						bok.setPages(sc.nextInt());
						count = 1;}
				}while(bok.getPages() < 0);
				count = 0;

				System.out.println("Enter Publisher Name: ");
				System.out.print("> ");
				Scanner sp = new Scanner(System.in);
				bok.setPublisher(sp.nextLine());
				bok.setBorrowed(true);
				for (Product allProduct : allProducts) {
					if (bok.getId() == allProduct.getId()) {
						System.out.println("Error: Product with ID " + allProduct.getId() + " is already registered.");
						id_count++;
					}
				}
				if(id_count == 0) {
					allProducts.add(bok);
					System.out.println("Successfully registered " + ((Book) bok).getTitle());
				}

			} catch (InputMismatchException e){
				System.out.println("Invalid Input : "+e);
				System.out.println("Register the Book Again :");
				register();
			}
		}

		else if (LibraryManager.isMovie()) {

			Scanner sc = new Scanner(System.in);
			Movie movie = new Movie();
			try{

				do {
					if (count == 1) {
						System.out.println("Invalid ID: negative number");
						System.out.println("Re-Enter product ID: ");
						System.out.print("> ");
						movie.setId(sc.nextInt());
					}
					else {
						System.out.println("Enter product ID: ");
						System.out.print("> ");
						movie.setId(sc.nextInt());
						count = 1;
					}
				}while(movie.getId() < 0);
				count = 0;

				Scanner st = new Scanner(System.in);
				System.out.println("Enter Title: ");
				System.out.print("> ");
				movie.setTitle(st.nextLine());
				System.out.println("Enter Value: ");
				System.out.print("> ");
				movie.setValue(sc.nextInt());
				System.out.println("Enter Length: ");
				System.out.print("> ");
				movie.setLength(sc.nextInt());
				Scanner sp = new Scanner(System.in);
				float fnumber;
				do {
					if (count == 1) {
						System.out.println("Invalid : Rating Range (0 - 10)  ");
						System.out.println("Re-Enter IMDB rating: ");
						System.out.print("> ");
						fnumber = sp.nextFloat();
						movie.setRating(fnumber);
					}
					else {
						System.out.println("Enter IMDB rating: ");
						System.out.print("> ");
						fnumber = sp.nextFloat();
						movie.setRating(fnumber);
						count = 1;
					}
				}while (fnumber < 0.0 || fnumber > 10.0);
				count = 0;

				movie.setBorrowed(true);

				for (Product allProduct : allProducts) {
					if (movie.getId() == allProduct.getId()) {
						System.out.println("Error: Product with ID " + allProduct.getId() + " is already registered.");
						id_count++;
					}
				}
				if(id_count == 0) {
					allProducts.add(movie);
					System.out.println("Successfully registered " + ((Movie) movie).getTitle());
				}

			} catch (InputMismatchException e){
				System.out.println("Invalid Input : "+e);
				System.out.println("Register the Movie Again :");
				register();
			}
		}
				writeRecord();
	}



	public void writeRecord(){

		try{
			FileOutputStream fos = new FileOutputStream(libPath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for ( Product prd : allProducts ) {
				oos.writeObject(prd);
			}

			fos.flush();
			oos.flush();
		}catch (FileNotFoundException e){
			System.out.println("ERROR: File Not Found Exception");
		}catch (IOException e){
			System.out.println("ERROR: IO Exception");
			e.printStackTrace();
		}
		//objFilePath ="mySerializedlibrary.bin";
		try {
			FileInputStream fin = new FileInputStream(libPath);
			ObjectInputStream oin = new ObjectInputStream(fin);

			Object object1 = oin.readObject();
			fin.close();
			oin.close();
		}catch (FileNotFoundException e){
			System.out.println("File Not Found Exception");
		}catch (IOException e){
			System.out.println("IO Exception");
		}catch (ClassNotFoundException e){
			System.out.println("Class Not Found Exception");
			e.printStackTrace();
		}
	}

	@Override
	public void deregister(String[] argument) {
		int input = Integer.parseInt(argument[0]);
		int count = 0;
		for (int i = 0; i < allProducts.size(); i++) {
			if (input == allProducts.get(i).getId()) {
				System.out.println("Successfully deregistered " + allProducts.get(i).getTitle());
				allProducts.remove(i);
				count++;
			}
		}
		writeRecord();

		if (count == 0)
				System.out.println("Error: No product with id "+argument[0]+" registered.");
		else
			count = 0;
	}

	@Override
	public void list() {
		if(allProducts.isEmpty())
			System.out.println("No Record found List is Empty: ");
		else
			for (Product allProduct : allProducts) {
				System.out.println(allProduct);
			}
	}

	@Override
	public void info(String[] argument) {

		int input = Integer.parseInt(argument[0]);
		int count = 0;
		for (Product allProduct : allProducts) {
			if (input == allProduct.getId()) {
				if (allProduct.getType() == 1)
					System.out.println("book " + allProduct.getTitle() + ": Value " + allProduct.getValue() + "kr, Pages " + allProduct.getPages() + ", Publisher Name " + allProduct.getPublisher());
				else if (allProduct.getType() == 0)
					 System.out.println("Movie " + allProduct.getTitle()+ ": Value " + allProduct.getValue() + "kr, Length " + allProduct.getLength() + ", Rating " + allProduct.getRating());
				count++;
			}
		}
		if(count == 0)
				System.out.println("Error: No product with id "+argument[0]+" registered.");
		else
			count = 0;
	}

	@Override
	public void checkin(String[] argument){
		int input = Integer.parseInt(argument[0]);
		int count = 0;
		for (Product allProduct : allProducts) {
			if (input == allProduct.getId()) {
				if (!allProduct.getBorrowed()) {
					allProduct.setBorrowed(true);
					System.out.println("Successfully returned " + allProduct.getTitle() + " from " + allProduct.getCustomerName());
					count++;
					writeRecord();
				}
				if (count == 0) {
					System.out.println("Cannot return " + allProduct.getTitle() + ". It is not borrowed by any customer.");
					count++;
				}
			}
		}
		if (count == 0)
			System.out.println("ID not exist "+argument[0]);
	}

	@Override
	public void checkout(String[] argument){
		int input = Integer.parseInt(argument[0]);
		int count = 0;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter customer name:" );
		String Name = in.nextLine();
		Scanner phone = new Scanner(System.in);
		System.out.println("Enter customer phone number:");
		String PhoneNo = phone.nextLine();
		for (Product allProduct : allProducts) {
			if (input == allProduct.getId()) {
				if (allProduct.getBorrowed()) {
					allProduct.setCustomerName(Name);
					allProduct.setCustomerPhoneNo(PhoneNo);
					allProduct.setBorrowed(false);
					System.out.println("Successfully lended to " + allProduct.getTitle() + " to " + allProduct.getCustomerName());
					count++;
					writeRecord();
				}
				if (count == 0) {
					System.out.println("Cannot lend to " + allProduct.getTitle() + " to another customer. It is already borrowed by " + allProduct.getCustomerName());
					count++;
				}
			}
		}
		if (count == 0)
			System.out.println("ID not exist "+argument[0]);
	}
}