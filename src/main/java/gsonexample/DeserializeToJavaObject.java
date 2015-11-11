package gsonexample;

import java.lang.reflect.*;

class DeserializeToJavaObject {
    
    @SuppressWarnings("unchecked")
    public static <T> T allocateInstanceWithOutConstructor(final Class<T> willAllocateClass) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        final Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        final Object unsafe = f.get(null);
        final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
        
        return (T) allocateInstance.invoke(unsafe, willAllocateClass);
    }
}
