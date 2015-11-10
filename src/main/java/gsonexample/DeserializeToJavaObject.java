package gsonexample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DeserializeToJavaObject {

    public static <T> T allocateInstanceWithOutConstructor(Class<T> willAllocateClass) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        final Object unsafe = f.get(null);
        final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);

        return (T) allocateInstance.invoke(unsafe, willAllocateClass);
    }
}
