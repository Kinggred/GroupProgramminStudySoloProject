package src.maks.shop;

import java.util.Date;

/**
 * @class Book
 * @brief Represents a book product with additional attributes such as author and publish date.
 *
 * The Book class extends the Product class, adding specific attributes and functionality for books.
 */
public class Book extends Product {

    /**
     * @brief The author of the book.
     */
    private final String author;

    /**
     * @brief The publication date of the book.
     */
    private final Date publishDate;

    /**
     * @brief Constructs a new Book object.
     *
     * @param name        The name of the book.
     * @param description A brief description of the book.
     * @param price       The price of the book.
     * @param author      The author of the book.
     * @param publishDate The publication date of the book.
     */
    public Book(String name, String description, double price, String author, Date publishDate) {
        super(name, description, price);
        this.author = author;
        this.publishDate = publishDate;
    }

    /**
     * @brief Returns a string representation of the book.
     *
     * @return A string containing the book's name, author, publication date, and price.
     */
    @Override
    public String toString() {
        return "Book: " + this.getName() + ", author: " + author + ", publishDate: " + publishDate + ", price: " + this.getPrice();
    }

    /**
     * @brief Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @brief Gets the publication date of the book.
     *
     * @return The publication date of the book.
     */
    public Date getPublishDate() {
        return publishDate;
    }
}