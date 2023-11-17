package persons;

import interaction.Interaction;
import interfaces.Greetable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Partner extends Person implements Greetable {

    private static final Logger LOGGER = LogManager.getLogger(Partner.class);
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

    public void greet (Person person) {
        LOGGER.info("Hello, " + person.getFirstName());
    };

    @Override
    public String toString() {
        return super.toString() +
                "companyName='" + companyName + '\'' +
                ", relation='" + relation + '\'' +
                " who is related to " + COMPANY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Partner partner = (Partner) o;
        return Objects.equals(companyName, partner.companyName) && Objects.equals(relation, partner.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName, relation);
    }
}
