package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstructionFactory {

    public Instruction createInstruction(String[] fields) {

        Instruction result = null;
        try {
            Class instructionClass = Class.forName(generateClassName(fields[1]));
            Constructor[] constructor = instructionClass.getConstructors();
            Object[] args = generateConstructorObjects(fields, constructor[0].getParameterTypes());
            result = (Instruction) constructor[0].newInstance(args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String generateClassName(String prefix) {
        return ("sml." + prefix.substring(0, 1).toUpperCase() + prefix.substring(1).toLowerCase() + "Instruction");
    }

    Object[] generateConstructorObjects(String[] fields, Class[] classParam) {

        if (fields.length != classParam.length) {
            throw new IllegalArgumentException("Argument object and parameter length mismatch");
        }
        Object[] objectRes = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            try {
                if (classParam[i].getSimpleName().equals("int")) {
                    objectRes[i] = Integer.parseInt(fields[i]);
                } else {
                    objectRes[i] = fields[i];
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return objectRes;
    }
}
