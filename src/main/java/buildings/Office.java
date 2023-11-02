package main.java.buildings;

import main.java.persons.Employee;

import java.util.ArrayList;

public class Office {

    private String address;
    private String phoneNumber;
    private ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public Office() {}

    public Office(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public void addEmployee(Employee employee) {
        this.employeesList.add(employee);
    };

    public void printEmployeeList() {
        for (int i = 0; i < employeesList.size(); i++) {
            System.out.println((employeesList.get(i)).toString());
        }
    }
}
