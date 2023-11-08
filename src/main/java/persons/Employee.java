package main.java.persons;

import main.java.interfaces.Greetable;
import main.java.interfaces.Payable;
import main.java.interfaces.Taxable;
import main.java.orders.Order;

public class Employee extends Person implements Greetable, Taxable {

    private String occupation;
    private int salary;

    public Employee() {}

    public Employee(String sex, String firstName, String lastName, String passportID, int age, String occupation, int salary) {
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

    public void greet (Person person) {
        System.out.println("Hello, " + person.getFirstName());
    };

    public void tax () {
        System.out.println(getOccupation() + " " + getFirstName() + " " + getLastName() +
                " should pay " + getSalary()/4 + " money as taxes this month");
    }

    @Override
    public String toString() {
        return super.toString() +
                "occupation='" + occupation + '\'' +
                ", salary=" + salary +
                " who works for " + COMPANY_NAME;
    }
}
