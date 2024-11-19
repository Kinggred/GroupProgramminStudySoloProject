package src.maks.shop;

import java.util.Calendar;
import java.util.Comparator;

/**
 * @class Person
 * @brief Represents a person with a name, surname, and birth year.
 *
 * The Person class provides basic information about a person and supports comparison based on age, surname, and name.
 */
public class Person implements Comparable<Person> {

    /**
     * @brief The first name of the person.
     */
    private final String name;

    /**
     * @brief The surname of the person.
     */
    private final String surname;

    /**
     * @brief The birth year of the person.
     */
    private final int birthYear;

    /**
     * @brief Constructs a new Person object with the specified name, surname, and birth year.
     *
     * @param name      The first name of the person.
     * @param surname   The surname of the person.
     * @param birthYear The birth year of the person.
     */
    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    /**
     * @brief Calculates the current age of the person.
     *
     * @return The person's age based on the current year and their birth year.
     */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    /**
     * @brief Returns a string representation of the person, including their name, surname, and age.
     *
     * @return A string containing the person's name, surname, and age in years.
     */
    @Override
    public String toString() {
        return name + " " + surname + " " + this.getAge() + " yrs";
    }

    /**
     * @brief Compares this person with another person based on their age, surname, and name.
     *
     * This comparison is done in the following order:
     * 1. Age (ascending)
     * 2. Surname (ascending)
     * 3. Name (ascending)
     *
     * @param o The person to compare this person to.
     * @return A negative integer, zero, or a positive integer as this person is less than, equal to, or greater than the specified person.
     */
    @Override
    public int compareTo(Person o) {
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        Comparator<Person> surnameComparator = Comparator.comparing(Person::getSurname);
        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> fullComparator = ageComparator.thenComparing(surnameComparator).thenComparing(nameComparator);
        return fullComparator.compare(this, o);
    }

    /**
     * @brief Gets the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Gets the surname of the person.
     *
     * @return The surname of the person.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @brief Gets the birth year of the person.
     *
     * @return The birth year of the person.
     */
    public int getBirthYear() {
        return birthYear;
    }
}