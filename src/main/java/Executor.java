package main.java;

import main.java.buildings.Office;
import main.java.items.Fan;
import main.java.items.Phone;
import main.java.persons.Client;
import main.java.persons.Employee;
import main.java.services.Cleaning;
import main.java.services.Service;

public class Executor {

    public static void main(String[] args) {

        Office office = new Office("Minsk", "200-10-20");

        Employee ivan = new Employee("Ivan", "Ivanov", "777", 30, 'M', "Manager", 1500);
        System.out.println(ivan.getFirstName() + " " + ivan.getLastName() + " position is " + ivan.getPosition());
        System.out.println(ivan.toString());
        Employee kate = new Employee("Kate", "Ivanova", "888", 26, 'F', "Admin", 2000);

        Service screenCleaning = new Cleaning("Screen Cleaning", 10, false);
        System.out.println(screenCleaning.getName() + " price is " + screenCleaning.getPrice());
        screenCleaning.action();

        Client bob = new Client("Bob", "Sponge", "666", 100, 'M', false);
        Phone xiaomi = new Phone("xiaomi", "2", "red", "02.02.2020", "5763289", 6000, 6.5);
        Fan fan = new Fan("Philips", "Fan", "white", "04.04.2004", "A+", 80);
        bob.addItem(xiaomi);
        bob.addItem(fan);
        System.out.println(bob.getItemsList().toString());

        office.addEmployee(ivan);
        office.addEmployee(kate);
        office.printEmployeeList();
    }
}
