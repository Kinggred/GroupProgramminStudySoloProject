package src.maks.shop;

import java.util.Comparator;

/**
 * @class SuperDuperOrder
 * @brief Represents a special type of order with enhanced functionalities.
 *
 * The SuperDuperOrder class extends the basic Order class, adding the ability to clone orders and providing a
 * comparator to order the orders by price.
 */
public class SuperDuperOrder extends Order implements Cloneable {

    /**
     * @brief A comparator for comparing orders based on the price of their associated products.
     */
    private static Comparator<? super SuperDuperOrder> OrderByPriceComparator;

    /**
     * @brief Constructs a new SuperDuperOrder with the specified client, product, and quantity.
     *
     * @param client   The client associated with the order.
     * @param product  The product being ordered.
     * @param quantity The quantity of the product being ordered.
     */
    public SuperDuperOrder(Client client, Product product, int quantity) {
        super(client, product, quantity);
    }

    /**
     * @brief Creates a clone of this SuperDuperOrder.
     *
     * @return A new SuperDuperOrder object that is a copy of the current instance.
     * @throws AssertionError If cloning is not supported.
     */
    @Override
    public SuperDuperOrder clone() {
        try {
            return (SuperDuperOrder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * @class OrderByPriceComparator
     * @brief A comparator for comparing SuperDuperOrder objects based on the price of their associated products.
     *
     * This comparator compares two SuperDuperOrder objects by their product prices in ascending order.
     */
    public static class OrderByPriceComparator implements Comparator<SuperDuperOrder> {

        /**
         * @brief Compares two SuperDuperOrder objects based on the price of their associated products.
         *
         * @param o1 The first SuperDuperOrder object.
         * @param o2 The second SuperDuperOrder object.
         * @return A negative integer, zero, or a positive integer as the first order's product price is less than,
         *         equal to, or greater than the second order's product price.
         */
        @Override
        public int compare(SuperDuperOrder o1, SuperDuperOrder o2) {
            return (int) (o1.getProduct().getPrice() - o2.getProduct().getPrice());
        }
    }

    /**
     * @brief Returns the comparator for ordering SuperDuperOrder objects by the price of their products.
     *
     * @return The comparator used to compare SuperDuperOrder objects by product price.
     */
    public static Comparator<? super SuperDuperOrder> getOrderByPriceComparator() {
        return OrderByPriceComparator;
    }
}