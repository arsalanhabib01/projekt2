import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryManager {

	private IntLib library;
	private static final String libPath = "library.bin";
	private static int counter = 0, Number;
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
		System.out.println("\nCurrent inventory:");
		// read file the current inventory from here

		try {
			manager.start();
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

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
		library.init();
		this.library.list();

		while (running) {
			System.out.print("> ");
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
						infoCommand(arguments);
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

						//	default:
						//		System.out.println("Unknown Command");
						//		continue;
				}
			} catch (IllegalArgumentException e){
				System.out.println("Illegal Command");
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


	private static void charCheck(String[] argument) { //New method can check characters in the command argument
		String str = argument[0];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
				counter++;
		}
	}

	private void checkoutCommand(String[] argument) {

	/*		String str = argument[0];
			int count = 0, Number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
					count++;
			}*/

		charCheck(argument);

		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else {
				this.library.checkout(argument);
				//System.out.println(Number);//this number will check if it is already exist
				//System.out.println("testing checkout " + argument[0]);
			}
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}

	}

	private void checkinCommand(String[] argument) {

	/*		String str = argument[0];
			int count = 0, Number = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
					count++;
			}*/
		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else{
				this.library.checkin(argument);
				//System.out.println(Number);//this number will check if it is already exist
				//System.out.println("testing checkin " + argument[0]);
			}
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0; }

	}



	private void deregisterCommand(String[] argument) {

	/*	String str = argument[0];
		int count = 0, Number = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
				count++;
		}*/
		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			//System.out.println(Number);
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else {
			//	System.out.println(Number);//this number will check if it is already exist

				this.library.deregister(argument);
				//System.out.println("Successfully deregistered " + argument[0]);
			}
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}
	}


	private void infoCommand(String[] argument){

/*		String str = argument[0];
		int count = 0, Number = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
				count++;
		}*/
		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			//System.out.println(Number);
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else {
				//	System.out.println(Number);//this number will check if it is already exist

				this.library.info(argument);
				//System.out.println("Library Information " + argument[0]);
			}
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}
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
		//	System.out.println("test movie" + movie);
		//	System.out.println("test book" + book);

			this.library.register();
		} else if (c == 'b') {
			setMovie(false);
			setBook(true);
		//	System.out.println("test book" + book);
		//	System.out.println("test movie" + movie);
			// call here class book
			this.library.register();
		} else {
			System.out.println("unknown character");
			registerCommand();
		}

	}

	private void listCommand() {
		this.library.list();
		//System.out.println("Command to get all books");

	}



}