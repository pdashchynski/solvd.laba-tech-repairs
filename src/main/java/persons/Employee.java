package persons;

import interaction.Interaction;
import interfaces.Greetable;
import interfaces.Payable;
import interfaces.Taxable;
import orders.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Employee extends Person implements Greetable, Taxable {

    private static final Logger LOGGER = LogManager.getLogger(Employee.class);
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
        LOGGER.info("Hello, " + person.getFirstName());
    };

    public void tax () {
        LOGGER.info(getOccupation() + " " + getFirstName() + " " + getLastName() +
                " should pay " + getSalary()/4 + " money as taxes this month");
    }

    @Override
    public String toString() {
        return super.toString() +
                "occupation='" + occupation + '\'' +
                ", salary=" + salary +
                " who works for " + COMPANY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(occupation, employee.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), occupation, salary);
    }
}
