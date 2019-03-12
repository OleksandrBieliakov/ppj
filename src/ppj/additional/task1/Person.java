package ppj.additional.task1;

public class Person {

    protected String name;
    protected int yearOfBirth;


    public Person (String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + yearOfBirth;
    }

}
