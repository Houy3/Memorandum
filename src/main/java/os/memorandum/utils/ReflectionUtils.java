package os.memorandum.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class ReflectionUtils extends org.springframework.util.ReflectionUtils {


    public static <T> Class<T> getGenericParameterClass(Class<?> actualClass, int parameterIndex) {

        Type type = actualClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type typeClazz = parameterizedType.getActualTypeArguments()[--parameterIndex];

        return (Class<T>) typeClazz;
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