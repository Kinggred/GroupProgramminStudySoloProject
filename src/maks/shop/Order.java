package src.maks.shop;

public class Order {
    private final Client client;
    private final Product product;
    private int quantity;

    public Order(Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order: " + quantity + "x" + product + ", Client: " + client.getName() + " " + client.getSurname();
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
