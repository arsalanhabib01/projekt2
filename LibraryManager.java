import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {

	private IntLib library;
	private static final String libPath = "library.csv";

	public enum Command {
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
		String userInput = scanner.nextLine();
		parseCommand(userInput);

	}


	public static Command parseCommand(String userInput) {

		String commandString = userInput.split(" ")[0];

		switch (commandString) {
			case "list":
				return Command.LIST;
			case "checkout":
				return Command.CHECKOUT;
			case "checkin":
				return Command.CHECKIN;
			case "register":
			//	System.out.println("Register");
				registerComamnd();
				break;
			case "deregister":
				return Command.DEREGISTER;
			case "info":
				return Command.INFO;

			case "quit":
				return Command.QUIT;
			default:
				return Command.UNKNOWN;
		}
		return null;
	}
	private static void registerComamnd() {
		System.out.println("testing register");
	}

	//private static void registerCommand() {
		//System.out.print("testing register");
//	}


	public void parseArgument(String[] userInput) {
		// TODO - implement LibraryManager.parseArgument
		throw new UnsupportedOperationException();
	}





}