package main.java.persons;

public class Employee extends Person{

    private String occupation;
    private int salary;

    public Employee() {}

    public Employee(char sex, String firstName, String lastName, String passportID, int age, String occupation, int salary) {
        super(sex, firstName, lastName, passportID, age);
        this.occupation = occupation;
        this.salary = salary;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "position='" + occupation + '\'' +
                ", salary=" + salary;
    }
}
