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
		Command commandString = parseCommand(userInput);


			String[] arguments = parseArguments(userInput);
			switch (commandString) {
				case LIST:
					break;
				case CHECKOUT:
					break;
				case CHECKIN:
					break;
				case REGISTER:
					registerCommand(arguments);
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

	private static void registerCommand(String[] argument) {

		String str = argument[0];
		int count = 0;
		for (int i = 0 ; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch<= 'z')
				count++;
		}
		if(count == 0)
			System.out.println("testing register " + argument[0]);
		else
			System.out.println("Cannot Register must be a number" );
	}

	private static void deregisterCommand(String[] argument) {

		System.out.println("testing de-register " + argument[0]);
	}

	//private static void registerCommand() {
		//System.out.print("testing register");
//	}


	public void parseArgument(String[] userInput) {
		// TODO - implement LibraryManager.parseArgument
		throw new UnsupportedOperationException();
	}





}