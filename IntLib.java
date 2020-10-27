public interface IntLib {

	void register();

	void deregister(String[] argument);

	void list();

	void info(String[] argument);

	void checkin(String[] argument);

	void checkout(String[] argument);

	void init();

}