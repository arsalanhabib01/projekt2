import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {

	private IntLib library;
	private static final String libPath = "library.bin";
	boolean running;

	public static void setBook(boolean book) {
		LibraryManager.book = book;
	}

	public static void setMovie(boolean movie) {
		LibraryManager.movie = movie;
	}

	public static boolean isBook() {
		return book;
	}

	public static boolean isMovie() {
		return movie;
	}

	private static boolean book = false;
	private static boolean movie = false;

	private enum Command {
		LIST,
		CHECKOUT,
		CHECKIN,
		REGISTER,
		DEREGISTER,
		INFO,
		QUIT,
		UNKNOWN
	}

	public static void main(String[] args) {
		LibraryManager manager = new LibraryManager(libPath);
		System.out.println("> java LibrarySystem\nWelcome!\nSuccesfully initialized system state from file(s).");
		System.out.println();
		System.out.println("Current inventory:\n");
		// read file the current inventory from here
		System.out.print("> ");
		manager.start();
	}

	public LibraryManager (String libPath) {
		try {
			library = new Library(libPath);
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			System.out.println("No file found at " + libPath);
			System.out.println("Exiting.");
			System.exit(0);
		}
	}


	public void start() {
		Scanner scanner = new Scanner(System.in);
		running = true;

		while (running) {

		String userInput = scanner.nextLine();

		try {
			Command commandString = parseCommand(userInput);

			String[] arguments = parseArguments(userInput);
			switch (commandString) {
				case LIST:
					if(arguments.length <= 0)
						listCommand();
					else {
						System.out.println("Illegal Argument");
						continue; }
					break;
				case CHECKOUT:
					checkoutCommand(arguments);
					break;
				case CHECKIN:
					checkinCommand(arguments);
					break;
				case REGISTER:
					if(arguments.length <= 0)
						registerCommand();
					else{
						System.out.println("Illegal Argument");
						continue;}
					break;
				case DEREGISTER:
					deregisterCommand(arguments);
					break;
				case INFO:
					break;
				case QUIT:
					if(arguments.length <= 0)
						quitCommand();
					else{
						System.out.println("Illegal Argument");
						continue;}
					break;
				case UNKNOWN:
					System.out.println("Unknown Command");
					continue;

				default:
					System.out.println("Unknown Command");
					continue;
			}
		} catch (IllegalArgumentException e){
			System.out.println("Illegal Argument");
			start();
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Missing Argument");
				continue;
		}
		}
		scanner.close();
	}

	private void quitCommand() {
		running = false;
		System.out.print("Exiting.");
		System.exit(0);
	}

	public static Command parseCommand(String userInput) {
		//try & catch!
		String commandString = userInput.split(" ")[0].toUpperCase();
		return Command.valueOf(commandString);

	}

	private String[] parseArguments(String userInput) {
		String[] arguments = userInput.split(" ");
		String[] arguments2 = new String[arguments.length-1];
		for (int i = 1; i < arguments.length; i++) {
			arguments2[i - 1] = arguments[i];
		}
		return arguments2;
	}

	private static void checkoutCommand(String[] argument) {

			String str = argument[0];
			int count = 0, Number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
					count++;
			}
			if (count == 0){
				Number = Integer.parseInt(argument[0]);
				if(Number < 0)
					System.out.println("Invalid Argument: Negative Numbers");
				else
					System.out.println("testing checkout " + argument[0]);
			}else
				System.out.println("Invalid Argument: Characters");

	}

	private static void checkinCommand(String[] argument) {

			String str = argument[0];
			int count = 0, Number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
					count++;
			}
		if (count == 0){
			Number = Integer.parseInt(argument[0]);
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else
				System.out.println("testing checkin " + argument[0]);
		}else
			System.out.println("Invalid Argument: Characters");

	}



	private void registerCommand() {

			System.out.println("What are you registering? Book (b), Movie (m) ");
			Scanner sc = new Scanner(System.in);
			char c;

			// Character input
			c = sc.next().charAt(0);
				if (c == 'm') {
					setMovie(true);
					setBook(false);
					// call here class movie
					System.out.println("test movie" + movie);
					this.library.register();
				} else if (c == 'b') {
					setMovie(false);
					setBook(true);
					System.out.println("test book" + book);
					// call here class book
					this.library.register();
				} else {
					System.out.println("unknown character");
					registerCommand();
				}

	}


	private void deregisterCommand(String[] argument) {

		String str = argument[0];
		int count = 0, Number = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
				count++;
		}
		if (count == 0){
			Number = Integer.parseInt(argument[0]);
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else {
				this.library.deregister();
				System.out.println("Successfully deregistered " + argument[0]);
			}
		}else
			System.out.println("Invalid Argument: Characters");
	}

	private void listCommand() {
		this.library.list();
		System.out.println("Command to get all books");

	}


}