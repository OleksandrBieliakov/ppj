package additional.task1;

public class Student extends Person {

    private int group;

    public Student(String name, int yearOfBirth, int group) {
        super(name, yearOfBirth);
        this.group = group;
    }

    public Student (String name, int yearOfBirth) {
        this(name, yearOfBirth, 0);
    }

    @Override
    public String toString() {
        return super.toString() + ", group: " + group;
    }

}
