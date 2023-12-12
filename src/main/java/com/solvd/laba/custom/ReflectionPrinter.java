package com.solvd.laba.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionPrinter {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionPrinter.class);

    public static void printClass(String name) {
        LOGGER.info("-----Class-----");

        try {
            Class<?> cl = Class.forName(name);
            Class<?> supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());

            LOGGER.info(modifiers + " " + "class " + name);
            if (supercl != null && supercl != Object.class) {
                LOGGER.info("extends " + supercl.getName());
            }
            printFields(cl);
            printConstructors(cl);
            printMethods(cl);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printConstructors(Class<?> cl) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        LOGGER.info("-----Constructors-----");

/*        for (Constructor<?> constructor : constructors) {
            String name = constructor.getName();
            String modifiers = Modifier.toString(constructor.getModifiers());
            StringBuilder parametersOutput = getParametersToPrint(constructor);

            LOGGER.info(modifiers + " " + name + "(" + parametersOutput + ");");
        }*/
        Arrays.stream(constructors).sequential().forEach(constructor -> {
            String name = constructor.getName();
            String modifiers = Modifier.toString(constructor.getModifiers());
            StringBuilder parametersOutput = getParametersToPrint(constructor);

            LOGGER.info(modifiers + " " + name + "(" + parametersOutput + ");");
        });
    }

    public static void printFields(Class<?> cl) {
        Field[] fields = cl.getDeclaredFields();
        LOGGER.info("-----Fields-----");

        for (Field field : fields) {
            Class<?> type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());

            LOGGER.info(modifiers + " " + type.getName() + " " + name + ";");
        }
    }

    public static void printMethods(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        LOGGER.info("-----Methods-----");

/*        for (Method method : methods) {
            Class<?> retType = method.getReturnType();
            String modifiers = Modifier.toString(method.getModifiers());
            StringBuilder parametersOutput = getParametersToPrint(method);

            LOGGER.info(modifiers + " " + retType.getName() + " " + method.getName() + "("
                        + parametersOutput + ");");
        }*/
        Arrays.stream(methods).sequential().forEach(method -> {
            String name = method.getName();
            String modifiers = Modifier.toString(method.getModifiers());
            StringBuilder parametersOutput = getParametersToPrint(method);

            LOGGER.info(modifiers + " " + name + "(" + parametersOutput + ");");
        });
    }

/*    private static Function<Executable, StringBuilder> getParameters = e -> {
        StringBuilder parametersOutput = new StringBuilder();
        Class<?>[] paramTypes = e.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++) {
            parametersOutput.append(paramTypes[j].getName());
            if (j != paramTypes.length-1) {
                parametersOutput.append(", ");
            }
        }
        return parametersOutput;
    };*/

    private static StringBuilder getParametersToPrint(Executable executable) {
        StringBuilder parameters = new StringBuilder();
        Class<?>[] paramTypes = executable.getParameterTypes();
        for (int j = 0; j < paramTypes.length; j++) {
            parameters.append(paramTypes[j].getName());
            if (j < paramTypes.length-1) {
                parameters.append(", ");
            }
        }
        return parameters;
    }
}
