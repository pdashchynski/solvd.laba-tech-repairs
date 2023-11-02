package main.java.persons;

public class Employee extends Person{

    private String position;
    private int salary;

    public Employee() {}

    public Employee(String firstName, String lastName, String passportID, int age, char sex, String position, int salary) {
        super(firstName, lastName, passportID, age, sex);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
                "position='" + position + '\'' +
                ", salary=" + salary;
    }
}
