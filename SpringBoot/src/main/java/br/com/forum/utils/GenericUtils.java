package br.com.forum.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtils {

    public static Object getNewInstance(Class clazz) {
        try {
            return clazz.newInstance();
        }
        catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

}

