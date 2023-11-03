package main.java.persons;

import java.util.Random;
import java.util.Scanner;

public class PersonGeneration {

    private final String[] firstNameMaleArray = new String[] {"Alex", "Boris", "Ivan", "Rich", "Az'akosh"};
    private final String[] firstNameFemaleArray = new String[] {"Alex", "Sonya", "Agatha", "Kate", "Gorlock"};
    private final String[] lastNameArray = new String[] {"Roberts", "Yeltsin", "Ivanov", "Campbell", "The Destroyer"};
    private final String[] occupationArray = new String[] {"Manager", "Administrator", "Cleaner"};
    private final String[] partnerCompanyNameArray = new String[] {"AMD", "Nvidia", "Intel", "Foodies"};

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

    public class PersonWrap {

        private Person person;
        private byte token;

        public PersonWrap () {}

        public PersonWrap (Person person, byte token) {
            this.person = person;
            this.token = token;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public byte getToken() {
            return token;
        }

        public void setToken(byte token) {
            this.token = token;
        }
    }

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

    public PersonWrap typeGenerate (String sex) {

        Random random = new Random();
        Scanner in = new Scanner(System.in);
        String occupation = new String();
        String relation = new String();
        String firstName = new String();
        char sexCh = sex.charAt(0);
        int baseSalary = 1000;
        byte token = 0;
        boolean isExit = false;
        PersonGeneration pg = new PersonGeneration();
        Person person = null;

        if (sex.equals("M")) {
            firstName = pg.personFirstNameMaleGenerate();
        } else if (sex.equals("F")) {
            firstName = pg.personFirstNameFemaleGenerate();
        }

        while (!isExit) {
            System.out.println("What type is your person? (Employee/Partner/Client)");
            String personType = in.next();

            switch (personType) {

                case "Client":
                    token = 1;
                    boolean isOurClient = true;
                    person = new Client(
                            sexCh,
                            firstName,
                            pg.personLastNameGenerate(),
                            pg.personPassportIDGenerate(),
                            pg.personAgeGenerate(),
                            isOurClient
                    );
                    isExit = true;
                    break;

                case "Employee":
                    System.out.println("Is that Employee one of our masters? (Y/N)");
                    String masterAnswer = in.next();

                    if (masterAnswer.equals("Y")) {
                        token = 3;
                        occupation = "Master";
                        int qualification = random.nextInt(10);
                        int salary = baseSalary *qualification;
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
                        token = 2;
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
                    isExit = true;
                    break;

                case "Partner":
                    token = 4;
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
                    isExit = true;
                    break;

                default:
                    System.out.println("Please enter a correct response");
                    break;
            }
        }
        return new PersonWrap(person, token);
    }
}
