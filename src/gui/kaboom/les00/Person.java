package gui.kaboom.les00;

public class Person {
    private String name;
    private int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHelloTo(Person other) {
        System.out.println("Hi " + other.name + "!");
    }

    public String getName(){
        return name;
    }

}
