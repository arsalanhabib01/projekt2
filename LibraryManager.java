public class LibraryManager {

	private IntLib library;

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
		System.out.println("Hello");		
	}
			
	public void start() {
		// TODO - implement LibraryManager.start
		throw new UnsupportedOperationException();
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
