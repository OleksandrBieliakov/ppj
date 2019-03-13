package ppj.additional.task1;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("Alex", 30);
        Person p2 = new Student("Bob", 20);
        Person p3 = new Professor("Ann", 33);

        Student s1 = new Student("Joe", 22, 11);
        Student s2 = new Student("Paul", 24);

        Professor pr1 = new Professor("Shon", 50, "Java");
        Professor pr2 = new Professor("Olga", 45);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(pr1);
        System.out.println(pr2);

        System.out.println(s1.getAge());

    }

}
