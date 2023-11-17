package com.solvd.laba.buildings;

import com.solvd.laba.persons.Employee;

import java.util.*;

public class Office {

    private String address;
    private String phoneNumber;
    private Set<Employee> employeeHashSet = new HashSet<>();

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

    public Set<Employee> getEmployeeHashSet() {
        return employeeHashSet;
    }

    public void setEmployeeHashSet(HashSet<Employee> employeeHashSet) {
        this.employeeHashSet = employeeHashSet;
    }

    public void addEmployeeToSet(Employee employee) {
        this.employeeHashSet.add(employee);
    };

    public void printEmployeesList() {
        for (Employee employee : employeeHashSet) {
            System.out.println(employee.toString());
        }
    }
}
