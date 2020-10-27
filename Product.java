public class Product {

    private String title;
    private int value;
    private int id;

    public String getTitle() {
        return title;
    }

    public int getValue() {
        return value;
    }

    public Product(int id, String title, int value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public Product() {
        
    }

    public int getId() {
        return id;
    }
}
