package src.maks.shop;

/**
 * @class Client
 * @brief Represents a client in the system.
 *
 * The Client class stores information about a person including their name, address, and email.
 */
public class Client {

    /**
     * @brief The first name of the client.
     */
    private final String name;

    /**
     * @brief The last name of the client.
     */
    private final String surname;

    /**
     * @brief The address of the client.
     */
    private final String address;

    /**
     * @brief The email address of the client.
     */
    private final String email;

    /**
     * @brief Constructs a new Client object with the specified details.
     *
     * @param name    The first name of the client.
     * @param surname The last name of the client.
     * @param address The address of the client.
     * @param email   The email address of the client.
     */
    public Client(String name, String surname, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    /**
     * @brief Returns a string representation of the client.
     *
     * @return A string containing the client's full name, address, and email.
     */
    @Override
    public String toString() {
        return "Client: " + name + " " + surname + ", address: " + address + ", email: " + email;
    }

    /**
     * @brief Gets the first name of the client.
     *
     * @return The first name of the client.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Gets the last name of the client.
     *
     * @return The last name of the client.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @brief Gets the address of the client.
     *
     * @return The address of the client.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @brief Gets the email address of the client.
     *
     * @return The email address of the client.
     */
    public String getEmail() {
        return email;
    }
}