package main.java.persons;

public class Master extends Employee {

    private int qualification;

    public Master () {}

    public Master (char sex, String firstName, String lastName, String passportID, int age, String position, int salary, int qualification) {
        super(sex, firstName, lastName, passportID, age, position, salary);
        this.qualification = qualification;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
}
