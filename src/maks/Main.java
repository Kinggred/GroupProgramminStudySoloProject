package src.maks;

import src.maks.shop.*;

import java.util.*;

/**
 * @class Main
 * @brief The main class responsible for executing different tests on the shop system.
 *
 * This class contains multiple tests that demonstrate the functionality of the `Client`, `Book`, `Order`,
 * `Person`, and `SuperDuperOrder` classes, including sorting, cloning, and price-based ordering.
 */
public class Main {

    /**
     * @brief The main method that executes all tests.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFourth();
    }

    /**
     * @brief Test that displays the clients, books, and orders.
     *
     * This test retrieves and prints a list of clients, books, and orders created using predefined data.
     */
    private static void testOne() {
        System.out.println("### TEST ONE ###");
        List<Client> clients = getClients();
        List<Book> books = getBooks();
        List<Order> orders = getOrders(books, clients);

        System.out.println("# Clients #");
        clients.forEach(System.out::println);
        System.out.println("# Books #");
        books.forEach(System.out::println);
        System.out.println("# Orders #");
        orders.forEach(System.out::println);
    }

    /**
     * @brief Test that demonstrates sorting of `Person` objects.
     *
     * This test prints a list of people, sorts them by age and name, and then prints the sorted list.
     */
    private static void testTwo() {
        System.out.println("### TEST TWO ###");
        System.out.println("# Unsorted #");
        List<Person> people = getPeople();
        people.forEach(System.out::println);
        people.sort(Person::compareTo);
        System.out.println("# Sorted #");
        people.forEach(System.out::println);
    }

    /**
     * @brief Test that demonstrates sorting `SuperDuperOrder` objects by price.
     *
     * This test sorts the list of `SuperDuperOrder` objects by the price of the product in the order.
     */
    private static void testThree() {
        System.out.println("### TEST THREE ###");
        List<Client> clients = getClients();
        List<Book> books = getBooks();
        List<SuperDuperOrder> mutableOrders = new ArrayList<>(getSuperDuperOrders(clients, books));
        mutableOrders.sort(new SuperDuperOrder.OrderByPriceComparator());
        System.out.println(mutableOrders);
    }

    /**
     * @brief Test that demonstrates cloning and modifying `SuperDuperOrder` objects.
     *
     * This test picks a random `SuperDuperOrder`, clones it, modifies the quantity of the cloned order,
     * and then prints both the original and cloned orders.
     */
    private static void testFourth() {
        System.out.println("### TEST FOURTH ###");
        List<Client> clients = getClients();
        List<Book> books = getBooks();
        List<SuperDuperOrder> mutableOrders = new ArrayList<>(getSuperDuperOrders(clients, books));
        mutableOrders.sort(new SuperDuperOrder.OrderByPriceComparator());

        SuperDuperOrder chosenOne = mutableOrders.get(new Random().nextInt(10));
        SuperDuperOrder clonedChosen = chosenOne.clone();
        // This might return the same value as the original one
        clonedChosen.setQuantity(new Random().nextInt(9));

        System.out.println(chosenOne);
        System.out.println(clonedChosen);
    }

    /**
     * @brief Retrieves a list of predefined clients.
     *
     * @return A list of `Client` objects.
     */
    private static List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Maks", "Grupiński", "Wola", "mail.mail"));
        clients.add(new Client("Smak", "Kusst", "Stany", "mail.mail"));
        clients.add(new Client("Kams", "Tuks", "Wanu", "mail.mail"));
        return clients;
    }

    /**
     * @brief Retrieves a list of predefined books.
     *
     * @return A list of `Book` objects.
     */
    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("ASD", "Desc", 123, "K.W. NKW", new Date()));
        books.add(new Book("DAS", "Desc", 100, "S.C. NKW", new Date()));
        books.add(new Book("SAD", "Desc", 50, "C.K. NOR", new Date()));
        return books;
    }

    /**
     * @brief Retrieves a list of orders based on the provided books and clients.
     *
     * @param books A list of `Book` objects.
     * @param clients A list of `Client` objects.
     * @return A list of `Order` objects.
     */
    private static List<Order> getOrders(List<Book> books, List<Client> clients) {
        List<Order> orders = new ArrayList<>();
        books.forEach(book -> {
            clients.forEach(client -> {
                orders.add(new Order(client, book, new Random().nextInt(9)));
            });
        });
        return orders;
    }

    /**
     * @brief Retrieves a list of predefined people.
     *
     * @return A list of `Person` objects.
     */
    private static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("ASD", "Desc", 2002));
        people.add(new Person("SDA", "Srac", 2001));
        people.add(new Person("DSA", "Cras", 2000));
        people.add(new Person("RSA", "Rcas", 2003));
        return people;
    }

    /**
     * @brief Converts a list of orders into `SuperDuperOrder` objects.
     *
     * @param clients A list of `Client` objects.
     * @param books A list of `Book` objects.
     * @return A list of `SuperDuperOrder` objects.
     */
    private static List<SuperDuperOrder> getSuperDuperOrders(List<Client> clients, List<Book> books) {
        return getOrders(books, clients).stream()
                .map(order -> new SuperDuperOrder(order.getClient(), order.getProduct(), order.getQuantity()))
                .toList();
    }
}
