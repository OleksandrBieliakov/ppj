package gui.werner.e04;

import java.util.Collection;

public class Person {
    private String name;
    private int yearOfBirth;

    public Person(String n, int y) {
        name = n;
        yearOfBirth = y;
    }

    @Override
    public String toString() {
        return name + "(" + yearOfBirth + ")";
    }

    public static boolean findInColl(Collection<Person> coll, String name, int year) {
        return coll.contains(new Person(name, year));
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        Person p = (Person)other;
        return name.equals(p.name) && yearOfBirth == p.yearOfBirth;
    }

    @Override
    public int hashCode() {
        return 17*name.hashCode() + yearOfBirth;
    }
}
