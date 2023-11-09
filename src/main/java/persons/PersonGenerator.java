package main.java.persons;

import java.util.ArrayList;

import static main.java.Executor.RANDOM;

public final class PersonGenerator {

    private static String[] firstNameMaleArray = new String[] {"Alex", "Boris", "Ivan", "Rich", "Az'akosh"};
    private static String[] firstNameFemaleArray = new String[] {"Alex", "Sonya", "Agatha", "Kate", "Gorlock"};
    private static String[] lastNameArray = new String[] {"Roberts", "Yeltsin", "Ivanov", "Campbell", "The Destroyer"};
    private static String[] occupationArray = new String[] {"Manager", "Administrator", "Cleaner"};
    private static String[] partnerCompanyNameArray = new String[] {"AMD", "Nvidia", "Intel", "Foodies"};
    private static String[] sexArray = new String[] {"M", "F"};
    private static int baseSalary = 1000;

    private static ArrayList<Client> clientList = new ArrayList<Client>();
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static ArrayList<Master> masterList = new ArrayList<Master>();
    private static ArrayList<Partner> partnerList = new ArrayList<Partner>();

    public String personFirstNameGenerate (String sex) {
        String firstName = "";
        if (sex.equals("M")) {
            firstName = firstNameMaleArray[RANDOM.nextInt(firstNameMaleArray.length)];
        } else if (sex.equals("F")) {
            firstName = firstNameFemaleArray[RANDOM.nextInt(firstNameFemaleArray.length)];
        }
        return firstName;
    }

    public String personLastNameGenerate () {
        return lastNameArray[RANDOM.nextInt(lastNameArray.length)];
    }

    public String personPassportIDGenerate () {
        return String.valueOf(RANDOM.nextInt(1000));
    }

    public int personAgeGenerate () {
        return RANDOM.nextInt(100) + 18;
    }

    public String personSexGenerate () {
        return sexArray[RANDOM.nextInt(sexArray.length)];
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
        String occupation = occupationArray[RANDOM.nextInt(occupationArray.length)];
        int salary = baseSalary * (RANDOM.nextInt(10) + 1);
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
        int qualification = RANDOM.nextInt(10) + 1;
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

        String partnerCompanyName = partnerCompanyNameArray[RANDOM.nextInt(partnerCompanyNameArray.length)];
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

    public void personGenerate (String personType) {

        String sex = personSexGenerate();

            switch (personType) {
                case "Client":
                    clientList.add(clientGenerate(sex));
                    break;

                case "Employee":
                    employeeList.add(employeeGenerate(sex, baseSalary));
                    break;

                case "Master":
                    masterList.add(masterGenerate(sex, baseSalary));
                    break;

                case "Partner":
                    partnerList.add(partnerGenerate(sex));
                    break;

                default:
                    break;
            }
    }

    public String[] getFirstNameMaleArray() {
        return firstNameMaleArray;
    }

    public void setFirstNameMaleArray(String[] firstNameMaleArray) {
        this.firstNameMaleArray = firstNameMaleArray;
    }

    public String[] getFirstNameFemaleArray() {
        return firstNameFemaleArray;
    }

    public void setFirstNameFemaleArray(String[] firstNameFemaleArray) {
        this.firstNameFemaleArray = firstNameFemaleArray;
    }

    public String[] getLastNameArray() {
        return lastNameArray;
    }

    public void setLastNameArray(String[] lastNameArray) {
        this.lastNameArray = lastNameArray;
    }

    public String[] getOccupationArray() {
        return occupationArray;
    }

    public void setOccupationArray(String[] occupationArray) {
        this.occupationArray = occupationArray;
    }

    public String[] getPartnerCompanyNameArray() {
        return partnerCompanyNameArray;
    }

    public void setPartnerCompanyNameArray(String[] partnerCompanyNameArray) {
        this.partnerCompanyNameArray = partnerCompanyNameArray;
    }

    public String[] getSexArray() {
        return sexArray;
    }

    public void setSexArray(String[] sexArray) {
        this.sexArray = sexArray;
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

    public int getBASE_SALARY() {
        return baseSalary;
    }

    public void setBASE_SALARY(int BASE_SALARY) {
        this.baseSalary = BASE_SALARY;
    }
}
