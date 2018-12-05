package e11.p1;

public class Person {

    private String name;
    private int birth;

    public Person(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }

    public Person(String name) {
        this.name = name;
        birth = 1990;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birth;
    }

    public boolean isFemale() {
        if(name.charAt(name.length()-1) == 'a')
            return true;
        return false;
    }

    public static Person getOlder(Person p1, Person p2) {
        if(p1.getBirthYear() > p2.getBirthYear())
            return p1;
        return p2;
    }

    public static Person getOldest(Person[] persons) {
        Person oldest = persons[0];
        for(int i = 1; i < persons.length; ++i) {
            if(persons[i].getBirthYear() > oldest.getBirthYear())
                oldest = persons[i];
        }
        return oldest;
    }

    public static Person getYoungestFemale(Person[] persons) {
        Person oldestF = null;
        int maxAge = 0;
        for(int i = 0; i < persons.length; ++i) {
            if(persons[i].isFemale())
                if(persons[i].getBirthYear() > maxAge) {
                    oldestF = persons[i];
                    maxAge = oldestF.getBirthYear();
                }
        }
        return oldestF;
    }

    @Override
    public String toString() {
        return name + "(" + birth + ")";
    }

}