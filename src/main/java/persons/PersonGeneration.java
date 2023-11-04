package main.java.persons;

import java.util.Random;
import java.util.Scanner;

public class PersonGeneration {

    private final String[] firstNameMaleArray = new String[] {"Alex", "Boris", "Ivan", "Rich", "Az'akosh"};
    private final String[] firstNameFemaleArray = new String[] {"Alex", "Sonya", "Agatha", "Kate", "Gorlock"};
    private final String[] lastNameArray = new String[] {"Roberts", "Yeltsin", "Ivanov", "Campbell", "The Destroyer"};
    private final String[] occupationArray = new String[] {"Manager", "Administrator", "Cleaner"};
    private final String[] partnerCompanyNameArray = new String[] {"AMD", "Nvidia", "Intel", "Foodies"};
    private final String[] sexArray = new String[] {"M", "F"};
    Random random = new Random();

    public String personFirstNameGenerate (String sex) {
        String firstName = "";
        if (sex.equals("M")) {
            firstName = firstNameMaleArray[random.nextInt(firstNameMaleArray.length)];
        } else if (sex.equals("F")) {
            firstName = firstNameFemaleArray[random.nextInt(firstNameFemaleArray.length)];
        }
        return firstName;
    }

    public String personLastNameGenerate () {
        return lastNameArray[random.nextInt(lastNameArray.length)];
    }

    public String personPassportIDGenerate () {
        return String.valueOf(random.nextInt(1000));
    }

    public int personAgeGenerate () {
        return random.nextInt(100) + 18;
    }

    public String personSexGenerate () {
        return sexArray[random.nextInt(sexArray.length)];
    }

    public Client clientGenerate (String sex) {
        return new Client(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                personAgeGenerate(),
                true
        );
    }

    public Employee employeeGenerate (String sex, int baseSalary) {
        String occupation = occupationArray[random.nextInt(occupationArray.length)];
        int salary = baseSalary * (random.nextInt(10) + 1);
        return new Employee(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                personAgeGenerate(),
                occupation,
                salary
        );
    }

    public Master masterGenerate (String sex, int baseSalary) {
        String occupation = "Master";
        int qualification = random.nextInt(10) + 1;
        int salary = baseSalary * qualification;
        return new Master(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                personAgeGenerate(),
                occupation,
                salary,
                qualification
        );
    }

    public Partner partnerGenerate (String sex) {
        String relation;

        String partnerCompanyName = partnerCompanyNameArray[random.nextInt(partnerCompanyNameArray.length)];
        if (partnerCompanyName.equals("Foodies")) {
            relation = "Catering";
        } else {
            relation = "Supplier";
        }

        return new Partner(
                sex,
                personFirstNameGenerate(sex),
                personLastNameGenerate(),
                personPassportIDGenerate(),
                personAgeGenerate(),
                partnerCompanyName,
                relation
        );
    }

    public Person personGenerate (String personType) {
        Person person = null;
        int baseSalary = 1000;

        String sex = personSexGenerate();

            switch (personType) {
                case "Client":
                    person = clientGenerate(sex);
                    break;

                case "Employee":
                    person = employeeGenerate(sex, baseSalary);
                    break;

                case "Master":
                    person = masterGenerate(sex, baseSalary);
                    break;

                case "Partner":
                    person = partnerGenerate(sex);
                    break;

                default:
                    break;
            }
        return person;
    }
}
