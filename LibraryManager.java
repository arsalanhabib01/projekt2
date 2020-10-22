import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {

	private IntLib library;
	private static final String libPath = "library.csv";
	boolean running;

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
		manager.start();

		Book bok1 = new Book(1, "Harry Potter", 302, 203, "JK. Rolling");
		System.out.println( bok1.toString()) ;



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
					listCommand();
					break;
				case CHECKOUT:
					checkoutCommand(arguments);
					break;
				case CHECKIN:
					checkinCommand(arguments);
					break;
				case REGISTER:
					registerCommand();
					break;
				case DEREGISTER:
					deregisterCommand(arguments);
					break;
				case INFO:
					break;

				case QUIT:
					quitCommand();
					break;

				case UNKNOWN:
					System.out.println("Unknown Command");
					continue;

				default:
					System.out.println("Unknown Command");
					continue;
			}
		} catch (IllegalArgumentException iae){
			System.out.println(iae.getMessage());
			start();
			}catch (ArrayIndexOutOfBoundsException aibe){
				System.out.println("Missing valid Id number");
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
					System.out.println("negative number invalid");
				else
					System.out.println("testing checkout " + argument[0]);
			}else
				System.out.println("Cannot checkout Id must be a number");

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
				System.out.println("negative number invalid");
			else
				System.out.println("testing checkin " + argument[0]);
		}else
			System.out.println("Cannot checkin Id must be a number");

	}

	private static void registerCommand() {
		LibraryManager manager = new LibraryManager(libPath); //not sure this is right
			System.out.println("What are you registering? Book (b), Movie (m) ");
			Scanner sc = new Scanner(System.in);
			char c;
			// Character input
			c = sc.next().charAt(0);
				if (c == 'm') {
					// call here class movie
					System.out.println("test movie");
				} else if (c == 'b') {
					// call here class book
					manager.library.register();
					System.out.println("test book");
				} else {
					System.out.println("unknown character");
					registerCommand();
				}

	}


	private static void deregisterCommand(String[] argument) {

		System.out.println("Successfully deregistered " + argument[0]);

	}

	private static void listCommand() {
		LinkedList<Object> allProducts = new LinkedList<Object>(Arrays.asList()); //working on this
		System.out.println("Command to get all books");
	}


}