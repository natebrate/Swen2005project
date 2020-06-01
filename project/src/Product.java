public class Product {
    private int prod_id;
    private String name;
    private int quantity;
    private double price;

    Product(int prod_id, String name, int quantity, double price)
    {
        this.prod_id = prod_id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProd_id() {
        return prod_id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }
}
