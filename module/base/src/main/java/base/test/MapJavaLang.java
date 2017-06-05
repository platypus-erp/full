package base.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
public class MapJavaLang {

    public static final Map<String, String> javalangAnnotation = new HashMap<>();
    public static final Map<String, String> javalangType = new HashMap<>();
    public static final Map<String, String> javalangException = new HashMap<>();
    static {
        javalangException.put(AbstractMethodError.class.getSimpleName(), "java.lang");
        javalangException.put(ArithmeticException.class.getSimpleName(), "java.lang");
        javalangException.put(ArrayIndexOutOfBoundsException.class.getSimpleName(), "java.lang");
        javalangException.put(ArrayStoreException.class.getSimpleName(), "java.lang");
        javalangException.put(BootstrapMethodError.class.getSimpleName(), "java.lang");
        javalangException.put(ClassCastException.class.getSimpleName(), "java.lang");
        javalangException.put(ClassCircularityError.class.getSimpleName(), "java.lang");
        javalangException.put(ClassFormatError.class.getSimpleName(), "java.lang");
        javalangException.put(ClassNotFoundException.class.getSimpleName(), "java.lang");
        javalangException.put(CloneNotSupportedException.class.getSimpleName(), "java.lang");
        javalangException.put(EnumConstantNotPresentException.class.getSimpleName(), "java.lang");
        javalangException.put(Error.class.getSimpleName(), "java.lang");
        javalangException.put(Exception.class.getSimpleName(), "java.lang");
        javalangException.put(ExceptionInInitializerError.class.getSimpleName(), "java.lang");
        javalangException.put(IllegalAccessError.class.getSimpleName(), "java.lang");
        javalangException.put(IllegalAccessException.class.getSimpleName(), "java.lang");
        javalangException.put(IllegalMonitorStateException.class.getSimpleName(), "java.lang");
        javalangException.put(IllegalStateException.class.getSimpleName(), "java.lang");
        javalangException.put(IllegalThreadStateException.class.getSimpleName(), "java.lang");
        javalangException.put(IncompatibleClassChangeError.class.getSimpleName(), "java.lang");
        javalangException.put(IndexOutOfBoundsException.class.getSimpleName(), "java.lang");
        javalangException.put(InstantiationError.class.getSimpleName(), "java.lang");
        javalangException.put(InstantiationException.class.getSimpleName(), "java.lang");

        javalangType.put(Appendable.class.getSimpleName(), "java.lang");
        javalangType.put(AutoCloseable.class.getSimpleName(), "java.lang");
        javalangType.put(Boolean.class.getSimpleName(), "java.lang");
        javalangType.put(Byte.class.getSimpleName(), "java.lang");
        javalangType.put(CharSequence.class.getSimpleName(), "java.lang");
        javalangType.put(Character.class.getSimpleName(), "java.lang");
        javalangType.put(Class.class.getSimpleName(), "java.lang");
        javalangType.put(ClassLoader.class.getSimpleName(), "java.lang");
        javalangType.put(ClassValue.class.getSimpleName(), "java.lang");
        javalangType.put(Cloneable.class.getSimpleName(), "java.lang");
        javalangType.put(Comparable.class.getSimpleName(), "java.lang");
        javalangType.put(Compiler.class.getSimpleName(), "java.lang");
        javalangType.put(Double.class.getSimpleName(), "java.lang");
        javalangType.put(Enum.class.getSimpleName(), "java.lang");
        javalangType.put(Float.class.getSimpleName(), "java.lang");
        javalangType.put(InheritableThreadLocal.class.getSimpleName(), "java.lang");
        javalangType.put(Integer.class.getSimpleName(), "java.lang");

        javalangAnnotation.put(Deprecated.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(Override.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(FunctionalInterface.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(SuppressWarnings.class.getSimpleName(), "java.lang");
    }
}
