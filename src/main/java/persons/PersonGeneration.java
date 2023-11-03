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

    public String personFirstNameMaleGenerate () {
        return firstNameMaleArray[random.nextInt(firstNameMaleArray.length)];
    }

    public String personFirstNameFemaleGenerate () {
        return firstNameFemaleArray[random.nextInt(firstNameFemaleArray.length)];
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

    public char personSexGenerate () {
        return sexArray[random.nextInt(sexArray.length)].charAt(0);
    }

    public Person personGenerate (String personType) {

        PersonGeneration pg = new PersonGeneration();
        Scanner in = new Scanner(System.in);
        String occupation = new String();
        String relation = new String();
        String firstName = new String();
        char sexCh = personSexGenerate();
        int baseSalary = 1000;
        Person person = null;

        if (sexCh == 'M') {
            firstName = pg.personFirstNameMaleGenerate();
        } else if (sexCh == 'F') {
            firstName = pg.personFirstNameFemaleGenerate();
        }

            switch (personType) {

                case "Client":
                    boolean isOurClient = true;
                    person = new Client(
                            sexCh,
                            firstName,
                            pg.personLastNameGenerate(),
                            pg.personPassportIDGenerate(),
                            pg.personAgeGenerate(),
                            isOurClient
                    );
                    break;

                case "Employee":
                    System.out.println("Is that Employee one of our masters? (Y/N)");
                    String masterAnswer = in.next();

                    if (masterAnswer.equals("Y")) {
                        occupation = "Master";
                        int qualification = random.nextInt(10);
                        int salary = baseSalary * qualification;
                        person = new Master(
                                sexCh,
                                firstName,
                                pg.personLastNameGenerate(),
                                pg.personPassportIDGenerate(),
                                pg.personAgeGenerate(),
                                occupation,
                                salary,
                                qualification
                        );
                    } else if (masterAnswer.equals("N")) {
                        occupation = occupationArray[random.nextInt(occupationArray.length)];
                        int salary = baseSalary *(random.nextInt(10));
                        person = new Employee(
                                sexCh,
                                firstName,
                                pg.personLastNameGenerate(),
                                pg.personPassportIDGenerate(),
                                pg.personAgeGenerate(),
                                occupation,
                                salary
                        );
                    }
                    break;

                case "Partner":
                    String partnerCompanyName = partnerCompanyNameArray[random.nextInt(partnerCompanyNameArray.length)];

                    if (partnerCompanyName.equals("Foodies")) {
                        relation = "Catering";
                    } else {
                        relation = "Supplier";
                    }
                    person = new Partner(
                            sexCh,
                            firstName,
                            pg.personLastNameGenerate(),
                            pg.personPassportIDGenerate(),
                            pg.personAgeGenerate(),
                            partnerCompanyName,
                            relation
                    );
                    break;

                default:
                    System.out.println("Please enter a correct response");
                    break;
            }

        return person;
    }
}
