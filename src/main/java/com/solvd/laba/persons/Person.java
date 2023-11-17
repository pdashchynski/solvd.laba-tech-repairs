package com.solvd.laba.persons;

import java.util.Objects;

public abstract class Person {

    protected static final String COMPANY_NAME = "Solvd";

    private String sex;
    private String firstName;
    private String lastName;
    private String passportID;
    private int age;

    public Person() {}

    public Person(String sex, String firstName, String lastName, String passportID, int age) {
        this.sex = sex;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportID = passportID;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "sex=" + sex +
                ",firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportID='" + passportID + '\'' +
                ", age=" + age + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(sex, person.sex) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(passportID, person.passportID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, firstName, lastName, passportID, age);
    }
}
