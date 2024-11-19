package src.maks.shop;

/**
 * @class Product
 * @brief Represents a product with a name, description, and price.
 *
 * The Product class serves as a base class for different types of products in the system. It holds the basic
 * attributes common to all products, such as name, description, and price.
 */
public abstract class Product {

    /**
     * @brief The name of the product.
     */
    private final String name;

    /**
     * @brief The description of the product.
     */
    private final String description;

    /**
     * @brief The price of the product.
     */
    private final double price;

    /**
     * @brief Constructs a new Product object with the specified name, description, and price.
     *
     * @param name        The name of the product.
     * @param description A brief description of the product.
     * @param price       The price of the product.
     */
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * @brief Returns a string representation of the product, including its name, description, and price.
     *
     * @return A string containing the product's name, description, and price.
     */
    @Override
    public String toString() {
        return "Product: " + name + ", desc: " + description + ", price: " + price;
    }

    /**
     * @brief Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Gets the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @brief Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }
}