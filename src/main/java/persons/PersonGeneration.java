package main.java.persons;

import java.util.Random;
import java.util.Scanner;

public class PersonGeneration {

    private String[] firstNameMaleArray = new String[] {"Alex", "Boris", "Ivan", "Rich", "Az'akosh"};
    private String[] firstNameFemaleArray = new String[] {"Alex", "Sonya", "Agatha", "Kate", "Gorlock"};
    private String[] lastNameArray = new String[] {"Roberts", "Yeltsin", "Ivanov", "Campbell", "The Destroyer"};
    private String[] occupationArray = new String[] {"Manager", "Administrator", "Cleaner"};
    private String[] partnerCompanyNameArray = new String[] {"AMD", "Nvidia", "Intel", "Foodies"};
    private int baseSalary = 1000;

/*    public String[] personBaseGenerate () {

        Random random = new Random();
        Scanner in = new Scanner(System.in);
        String sexType = new String();
        String firstName = new String();
        String lastName = new String();
        boolean isExit = false;

        while (isExit) {
            System.out.println("What sex is your person? (M/F)");
            sexType = in.next();

            switch (sexType) {
                case "M":
                    firstName = firstNameMaleArray[random.nextInt(firstNameMaleArray.length)];
                    lastName = lastNameArray[random.nextInt(lastNameArray.length)];
                    isExit = true;
                    break;

                case "F":
                    firstName = firstNameFemaleArray[random.nextInt(firstNameFemaleArray.length)];
                    lastName = lastNameArray[random.nextInt(lastNameArray.length)];
                    isExit = true;
                    break;

                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }
        String[] basePersonArray = new String[] {sexType, firstName, lastName};
        return basePersonArray;
    }*/

    public String personFirstNameMaleGenerate () {
        Random random = new Random();
        String firstNameMale = firstNameMaleArray[random.nextInt(firstNameMaleArray.length)];
        return firstNameMale;
    }

    public String personFirstNameFemaleGenerate () {
        Random random = new Random();
        String firstNameFemale = firstNameFemaleArray[random.nextInt(firstNameFemaleArray.length)];
        return firstNameFemale;
    }

    public String personLastNameGenerate () {
        Random random = new Random();
        String lastName = lastNameArray[random.nextInt(lastNameArray.length)];
        return lastName;
    }

    public String personPassportIDGenerate () {
        Random random = new Random();
        String passportID = String.valueOf(random.nextInt(1000));
        return passportID;
    }

    public int personAgeGenerate () {
        Random random = new Random();
        int age = random.nextInt(100) + 18;
        return age;
    }

    public Person typeGenerate () {

        Random random = new Random();
        Scanner in = new Scanner(System.in);
        String occupation = new String();
        String relation = new String();
        boolean isExit = false;
        PersonGeneration pg = new PersonGeneration();
        Person person = null;

        while (!isExit) {
            System.out.println("What type is your person? (Employee/Partner/Client)");
            String personType = in.next();

            switch (personType) {
                case "Employee":
                    System.out.println("Is that Employee one of our masters? (Y/N)");
                    String masterAnswer = in.next();

                    if (masterAnswer == "Y") {
                        occupation = "Master";
                        int qualification = random.nextInt(10);
                        int salary = baseSalary*qualification;
                        person = new Master();
                    } else if (masterAnswer == "N") {
                        occupation = occupationArray[random.nextInt(occupationArray.length)];
                        int salary = baseSalary*(random.nextInt(10));
                        person = new Employee();
                    }
                    isExit = true;
                    break;

                case "Partner":
                    String partnerCompanyName = partnerCompanyNameArray[random.nextInt(partnerCompanyNameArray.length)];

                    if ( (partnerCompanyName.equals("AMD")) | (partnerCompanyName.equals("Nvidia")) | (partnerCompanyName.equals("Intel")) ) {
                        relation = "Supplier";
                    } else if (partnerCompanyName.equals("Foodies")) {
                        relation = "Catering";
                    }
                    person = new Partner();
                    isExit = true;
                    break;

                case "Client":
                    boolean isOurClient = true;
                    person = new Client(
                            'F',
                            pg.personFirstNameFemaleGenerate(),
                            pg.personLastNameGenerate(),
                            pg.personPassportIDGenerate(),
                            pg.personAgeGenerate(),
                            isOurClient
                    );
                    isExit = true;
                    break;

                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }
        return person;
    }
}
