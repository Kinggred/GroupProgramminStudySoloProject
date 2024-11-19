package src.maks.shop;

public class Client {
    private final String name;
    private final String surname;
    private final String address;
    private final String email;

    public Client(String name, String surname, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
    }

    public String toString() {
        return "Client: " + name + " " + surname + ", address: " + address + ", email: " + email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
