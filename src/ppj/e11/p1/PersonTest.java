package ppj.e11.p1;

public class PersonTest {

    public static void main(String[] args) {

        Person[] persons = { new Person("Bobo", 1995), new Person("Robb", 1990), new Person("Rick", 1997),
                new Person("Anna", 1994), new Person("John", 1992), new Person("Ala", 1991) };

        System.out.println(persons[0].getName());
        System.out.println(Person.getOlder(persons[0], persons[2]));
        System.out.println(Person.getOldest(persons));
        System.out.println(persons[0].isFemale());
        System.out.println(persons[3].isFemale());
        System.out.println(Person.getYoungestFemale(persons));

    }

}