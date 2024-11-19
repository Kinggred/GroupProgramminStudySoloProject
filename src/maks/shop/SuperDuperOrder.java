package src.maks.shop;

import java.util.Comparator;

public class SuperDuperOrder extends Order implements Cloneable {
    private static Comparator<? super SuperDuperOrder> OrderByPriceComparator;

    public SuperDuperOrder(Client client, Product product, int quantity) {
        super(client, product, quantity);
    }

    @Override
    public SuperDuperOrder clone() {
        try {
            return (SuperDuperOrder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static class OrderByPriceComparator implements Comparator<SuperDuperOrder> {
        @Override
        public int compare(SuperDuperOrder o1, SuperDuperOrder o2) {
            return (int) (o1.getProduct().getPrice() - o2.getProduct().getPrice());
        }
    }

    public static Comparator<? super SuperDuperOrder> getOrderByPriceComparator() {
        return OrderByPriceComparator;
    }
}
