package src.maks;

import src.maks.shop.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFourth();
    }

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

    private static void testTwo() {
        System.out.println("### TEST TWO ###");
        System.out.println("# Unsorted #");
        List<Person> people = getPeople();
        people.forEach(System.out::println);
        people.sort(Person::compareTo);
        System.out.println("# Sorted #");
        people.forEach(System.out::println);
    }

    private static void testThree() {
        System.out.println("### TEST THREE ###");
        List<Client> clients = getClients();
        List<Book> books = getBooks();
        List<SuperDuperOrder> mutableOrders = new ArrayList<>(getSuperDuperOrders(clients, books));
        mutableOrders.sort(new SuperDuperOrder.OrderByPriceComparator());
        System.out.println(mutableOrders);
    }

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

    private static List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Maks", "Grupiński", "Wola", "mail.mail"));
        clients.add(new Client("Smak", "Kusst", "Stany", "mail.mail"));
        clients.add(new Client("Kams", "Tuks", "Wanu", "mail.mail"));
        return clients;
    }

    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("ASD", "Desc", 123, "K.W. NKW", new Date()));
        books.add(new Book("DAS", "Desc", 100, "S.C. NKW", new Date()));
        books.add(new Book("SAD", "Desc", 50, "C.K. NOR", new Date()));
        return books;
    }

    private static List<Order> getOrders(List<Book> books, List<Client> clients) {
        List<Order> orders = new ArrayList<>();
        books.forEach(book -> {
            clients.forEach(client -> {
               orders.add(new Order(client, book, new Random().nextInt(9)));
            });
        });
        return orders;
    }

    private static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("ASD", "Desc", 2002));
        people.add(new Person("SDA", "Srac", 2001));
        people.add(new Person("DSA", "Cras", 2000));
        people.add(new Person("RSA", "Rcas", 2003));
        return people;
    }

    private static List<SuperDuperOrder> getSuperDuperOrders(List<Client> clients, List<Book> books) {
        return getOrders(books, clients).stream().map(order -> new SuperDuperOrder(order.getClient(), order.getProduct(), order.getQuantity())).toList();
    }
}
