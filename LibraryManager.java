import java.io.FileNotFoundException;

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
		System.out.print("Hello hello");
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
				return Command.REGISTER;
			case "deregister":
				return Command.DEREGISTER;
			case "info":
				return Command.INFO;

			case "quit":
				return Command.QUIT;
			default:
				return Command.UNKNOWN;
		}
	}


	public void parseArgument(String[] userInput) {
		// TODO - implement LibraryManager.parseArgument
		throw new UnsupportedOperationException();
	}



}