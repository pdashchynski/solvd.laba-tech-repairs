package main.java.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedListUsage {

    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedListUsage.class);

    public static void use() {
        CustomLinkedList cll = new CustomLinkedList();
        CustomLinkedList.customLinkedList<Integer> cllList = cll.new customLinkedList<>();
        cllList.add(25);
        cllList.add(75);
        LOGGER.info(cllList);
        cllList.add(2, 50);
        LOGGER.info(cllList);
    }
}
