package com.solvd.laba.persons;

import com.solvd.laba.exceptions.InvalidAgeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

public final class PersonGenerator {

    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = LogManager.getLogger(PersonGenerator.class);
    private static final String[] FIRST_NAME_MALE_ARRAY = new String[] {"Alex", "Boris", "Ivan", "Rich", "Az'akosh"};
    private static final String[] FIRST_NAME_FEMALE_ARRAY = new String[] {"Alex", "Sonya", "Agatha", "Kate", "Gorlock"};
    private static final String[] LAST_NAME_ARRAY = new String[] {"Roberts", "Yeltsin", "Ivanov", "Campbell", "The Destroyer"};
    private static final String[] OCCUPATION_ARRAY = new String[] {"Manager", "Administrator", "Cleaner"};
    private static final String[] PARTNER_COMPANY_NAME_ARRAY = new String[] {"AMD", "Nvidia", "Intel", "Foodies"};
    private static final String[] SEX_ARRAY = new String[] {"M", "F"};
    private static final int BASE_SALARY = 1000;

    private static ArrayList<Client> clientList = new ArrayList<Client>();
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static ArrayList<Master> masterList = new ArrayList<Master>();
    private static ArrayList<Partner> partnerList = new ArrayList<Partner>();

    public String personFirstNameGenerate (String sex) {
        String firstName = "";
        if (sex.equals("M")) {
            firstName = FIRST_NAME_MALE_ARRAY[RANDOM.nextInt(FIRST_NAME_MALE_ARRAY.length)];
        } else if (sex.equals("F")) {
            firstName = FIRST_NAME_FEMALE_ARRAY[RANDOM.nextInt(FIRST_NAME_FEMALE_ARRAY.length)];
        }
        return firstName;
    }

    public UnaryOperator<String> firstName = sex -> {
        String firstName = "";
        if (sex.equals("M")) {
            firstName = FIRST_NAME_MALE_ARRAY[RANDOM.nextInt(FIRST_NAME_MALE_ARRAY.length)];
        } else if (sex.equals("F")) {
            firstName = FIRST_NAME_FEMALE_ARRAY[RANDOM.nextInt(FIRST_NAME_FEMALE_ARRAY.length)];
        }
        return firstName;
    };

    public String personLastNameGenerate () {
        return LAST_NAME_ARRAY[RANDOM.nextInt(LAST_NAME_ARRAY.length)];
    }

    public String personPassportIDGenerate () {
        return String.valueOf(RANDOM.nextInt(1000));
    }

    public int personAgeGenerate () throws InvalidAgeException{
        int age = RANDOM.nextInt(100) + 18;
        if (age < 18) {
            throw new InvalidAgeException("Underage person", age);
        }
        return age;
    }

    public String personSexGenerate () {
        return SEX_ARRAY[RANDOM.nextInt(SEX_ARRAY.length)];
    }

    public Client clientGenerate (String sex) {
        int age = 0;
        try {
            age = personAgeGenerate();
        } catch (InvalidAgeException e) {
            LOGGER.debug(e.getMessage());
        }
        return new Client(
                sex,
                firstName.apply(sex),
                //personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                age,
                true
        );
    }

    public Employee employeeGenerate (String sex, int baseSalary) {
        String occupation = OCCUPATION_ARRAY[RANDOM.nextInt(OCCUPATION_ARRAY.length)];
        int salary = baseSalary * (RANDOM.nextInt(10) + 1);
        int age = 0;
        try {
            age = personAgeGenerate();
        } catch (InvalidAgeException e) {
            LOGGER.debug(e.getMessage());
        }
        return new Employee(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                age,
                occupation,
                salary
        );
    }

    public Master masterGenerate (String sex, int baseSalary) {
        String occupation = "Master";
        int qualification = RANDOM.nextInt(10) + 1;
        int salary = baseSalary * qualification;
        int age = 0;
        try {
            age = personAgeGenerate();
        } catch (InvalidAgeException e) {
            LOGGER.debug(e.getMessage());
        }
        return new Master(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                age,
                occupation,
                salary,
                qualification
        );
    }

    public Partner partnerGenerate (String sex) {
        String relation;

        String partnerCompanyName = PARTNER_COMPANY_NAME_ARRAY[RANDOM.nextInt(PARTNER_COMPANY_NAME_ARRAY.length)];
        if (partnerCompanyName.equals("Foodies")) {
            relation = "Catering";
        } else {
            relation = "Supplier";
        }

        int age = 0;
        try {
            age = personAgeGenerate();
        } catch (InvalidAgeException e) {
            LOGGER.debug(e.getMessage());
        }

        return new Partner(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                age,
                partnerCompanyName,
                relation
        );
    }

    public void personGenerate (String personType) {

        String sex = personSexGenerate();

            switch (personType) {
                case "Client":
                    clientList.add(clientGenerate(sex));
                    break;

                case "Employee":
                    employeeList.add(employeeGenerate(sex, BASE_SALARY));
                    break;

                case "Master":
                    masterList.add(masterGenerate(sex, BASE_SALARY));
                    break;

                case "Partner":
                    partnerList.add(partnerGenerate(sex));
                    break;

                default:
                    break;
            }
    }

    public String[] getFirstNameMaleArray() {
        return FIRST_NAME_MALE_ARRAY;
    }

    public String[] getFirstNameFemaleArray() {
        return FIRST_NAME_FEMALE_ARRAY;
    }

    public String[] getLastNameArray() {
        return LAST_NAME_ARRAY;
    }

    public String[] getOccupationArray() {
        return OCCUPATION_ARRAY;
    }

    public String[] getPartnerCompanyNameArray() {
        return PARTNER_COMPANY_NAME_ARRAY;
    }

    public String[] getSexArray() {
        return SEX_ARRAY;
    }

    public int getBASE_SALARY() {
        return BASE_SALARY;
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<Master> getMasterList() {
        return masterList;
    }

    public ArrayList<Partner> getPartnerList() {
        return partnerList;
    }
}
