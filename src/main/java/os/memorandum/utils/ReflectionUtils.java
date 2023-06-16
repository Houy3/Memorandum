package os.memorandum.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {


    public static <T> Class<T> getGenericParameterClass(Class<?> actualClass, int parameterIndex) {
        try {
            return (Class<T>)((ParameterizedType)actualClass.getGenericSuperclass()).getActualTypeArguments()[--parameterIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Wrong parameterIndex.");
        } catch (Exception e) {
            throw new IllegalArgumentException("Problems with actualClass.");
        }
    }

    public static <T> T getObject(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("An empty constructor is required.");
        }
    }


}