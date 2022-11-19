public class Product {
    protected int id;
    protected String name;
    protected int price;

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
