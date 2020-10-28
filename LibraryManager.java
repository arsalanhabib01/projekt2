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
		manager.library.init();
		manager.library.list();
		try {
			manager.start();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	public LibraryManager (String libPath) {
		try {
			library = new Library(libPath);
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			System.out.println("ERROR: No File Found at " + libPath);
			System.out.println("Exiting.");
			System.exit(0);
		}
	}


	public void start() {

		Scanner scanner = new Scanner(System.in);
		running = true;

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
							System.out.println("ERROR: Invalid Argument");
							continue; }
						break;
					case CHECKOUT:
						if(arguments.length > 1) {
							System.out.println("ERROR: Invalid Argument");
						continue;}
						else
							checkoutCommand(arguments);
						break;
					case CHECKIN:
						if(arguments.length > 1) {
							System.out.println("ERROR: Invalid Argument");
							continue;}
						else
							checkinCommand(arguments);
						break;
					case REGISTER:
						if(arguments.length <= 0) {
							registerCommand();
						}
						else{
							System.out.println("ERROR: Invalid Argument");
							continue;}
						break;
					case DEREGISTER:
						if(arguments.length > 1) {
							System.out.println("ERROR: Invalid Argument");
							continue;}
						else
							deregisterCommand(arguments);
						break;
					case INFO:
						if(arguments.length > 1) {
							System.out.println("ERROR: Invalid Argument");
							continue;}
						else
						infoCommand(arguments);
						break;
					case QUIT:
						if(arguments.length <= 0)
							quitCommand();
						else{
							System.out.println("ERROR: Invalid Argument");
							continue;}
						break;
					case UNKNOWN:
						System.out.println("ERROR: Unknown Command");

				}
			} catch (IllegalArgumentException e){
				System.out.println("ERROR: Invalid Command");
				start();
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("ERROR: Missing Argument");
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

		charCheck(argument);

		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else
				this.library.checkout(argument);
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}
	}

	private void checkinCommand(String[] argument) {

		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else
				this.library.checkin(argument);
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0; }
	}



	private void deregisterCommand(String[] argument) {

		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else
				this.library.deregister(argument);
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}
	}


	private void infoCommand(String[] argument){

		charCheck(argument);
		if (counter == 0){
			Number = Integer.parseInt(argument[0]);
			counter = 0;
			if(Number < 0)
				System.out.println("Invalid Argument: Negative Numbers");
			else
				this.library.info(argument);
		}else {
			System.out.println("Invalid Argument: Characters");
			counter = 0;}
	}

	private void registerCommand() {

		System.out.println("What are you registering? Book (b), Movie (m) ");
		Scanner sc = new Scanner(System.in);
		char c;

		c = sc.next().charAt(0);
		if (c == 'm') {
			setMovie(true);
			setBook(false);
			this.library.register();
		} else if (c == 'b') {
			setMovie(false);
			setBook(true);
			this.library.register();
		} else {
			System.out.println("unknown character");
			registerCommand();
		}

	}

	private void listCommand() {
		System.out.println("ID   " + "TYPE   " + "NAME   " + "STATE");
		this.library.list();
	}
}