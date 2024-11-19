package src.maks.shop;

/**
 * @class Order
 * @brief Represents an order placed by a client for a specific product.
 *
 * The Order class associates a client with a product, along with the quantity of the product ordered.
 */
public class Order {

    /**
     * @brief The client who placed the order.
     */
    private final Client client;

    /**
     * @brief The product being ordered.
     */
    private final Product product;

    /**
     * @brief The quantity of the product being ordered.
     */
    private int quantity;

    /**
     * @brief Constructs a new Order object.
     *
     * @param client   The client who placed the order.
     * @param product  The product being ordered.
     * @param quantity The quantity of the product ordered.
     */
    public Order(Client client, Product product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @brief Returns a string representation of the order.
     *
     * @return A string containing the order details, including the quantity, product, and client.
     */
    @Override
    public String toString() {
        return "Order: " + quantity + "x" + product + ", Client: " + client.getName() + " " + client.getSurname();
    }

    /**
     * @brief Gets the client who placed the order.
     *
     * @return The client associated with the order.
     */
    public Client getClient() {
        return client;
    }

    /**
     * @brief Gets the product being ordered.
     *
     * @return The product associated with the order.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @brief Gets the quantity of the product being ordered.
     *
     * @return The quantity of the product ordered.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @brief Updates the quantity of the product in the order.
     *
     * @param quantity The new quantity of the product.
     * @return The updated Order object.
     */
    public Order setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}