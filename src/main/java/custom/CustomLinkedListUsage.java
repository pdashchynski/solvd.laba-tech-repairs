package main.java.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.sql.Types.NULL;

public class CustomLinkedListUsage {

    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedListUsage.class);

    public static void use() {
        CustomLinkedList<Integer> cllList = new CustomLinkedList<>();
        cllList.add(25);
        cllList.add(NULL);
        cllList.add(75);
        LOGGER.info(cllList);
        cllList.add(2, 50);
        cllList.add(100);
        LOGGER.info(cllList);
    }
}
