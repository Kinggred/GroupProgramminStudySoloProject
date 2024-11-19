package src.maks.shop;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person> {
    private final String name;
    private final String surname;
    private final int birthYear;

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + this.getAge() + " yrs";
    }

    @Override
    public int compareTo(Person o) {
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
        Comparator<Person> surnameComparator = Comparator.comparing(Person::getSurname);
        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> fullComparator = ageComparator.thenComparing(surnameComparator).thenComparing(nameComparator);
        return fullComparator.compare(this, o);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }
}