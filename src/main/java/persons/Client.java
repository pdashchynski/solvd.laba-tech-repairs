package main.java.persons;

import main.java.interaction.Interaction;
import main.java.interfaces.Greetable;
import main.java.items.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Client extends Person implements Greetable {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    private boolean isOurClient;
    private ArrayList<Computer> computerList = new ArrayList<Computer>();

    public Client() {}

    public Client(String sex, String firstName, String lastName, String passportID, int age, boolean isOurClient) {
        super(sex, firstName, lastName, passportID, age);
        this.isOurClient = isOurClient;
    }

    public boolean isOurClient() {
        return isOurClient;
    }

    public void setOurClient(boolean ourClient) {
        isOurClient = ourClient;
    }

    public ArrayList<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(ArrayList<Computer> computerList) {
        this.computerList = computerList;
    }

    public void addComputerToComputerList(Computer computer) {
        this.computerList.add(computer);
    }

    public void greet (Person person) {
        LOGGER.info("Hello, " + person.getFirstName());
    };

    @Override
    public String toString() {
        return  super.toString() +
                " who came to " + COMPANY_NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return isOurClient == client.isOurClient && Objects.equals(computerList, client.computerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOurClient, computerList);
    }
}
