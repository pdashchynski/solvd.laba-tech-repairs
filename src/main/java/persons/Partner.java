package main.java.persons;

public class Partner extends Person {

    private String companyName;
    private String relation;

    public Partner() {}

    public Partner(String sex, String firstName, String lastName, String passportID, int age, String companyName, String relation) {
        super(sex, firstName, lastName, passportID, age);
        this.companyName = companyName;
        this.relation = relation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return super.toString() +
                "companyName='" + companyName + '\'' +
                ", relation='" + relation + '\'';
    }
}