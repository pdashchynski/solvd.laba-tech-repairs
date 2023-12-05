package com.solvd.laba.custom;

import com.solvd.laba.persons.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionCreator {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionPrinter.class);

    public static void createClass(String name) {
        try {
            Constructor<?> constructor = Class.forName(name).getConstructor();
            Object newInstance = constructor.newInstance();
            LOGGER.info(newInstance.toString());
/*            Client client = Client.class
                                    .getConstructor(String.class, String.class, String.class,
                                                    String.class, int.class, boolean.class)
                                    .newInstance("M", "First", "Last", "1", 18, false);
            LOGGER.info(client.toString());*/
        } catch (NoSuchMethodException
                 | IllegalAccessException
                 | InstantiationException
                 | InvocationTargetException
                 | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
