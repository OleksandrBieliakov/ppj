package ppj.additional.task1;

public class Professor extends Person {

    private String subject;

    public Professor (String name, int yearOfBirth, String subject) {
        super(name, yearOfBirth);
        this.subject = subject;
    }

    public Professor (String name, int yearOfBirth) {
        this(name, yearOfBirth, "not assigned");
    }

    @Override
    public String toString() {
        return super.toString() + ", subject: " + subject;
    }

}
