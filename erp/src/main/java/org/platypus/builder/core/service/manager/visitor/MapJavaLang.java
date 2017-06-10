package org.platypus.builder.core.service.manager.visitor;

import javax.annotation.processing.ProcessingEnvironment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/06/17.
 */
class MapJavaLang {

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
        javalangException.put(InternalError.class.getSimpleName(), "java.lang");
        javalangException.put(InterruptedException.class.getSimpleName(), "java.lang");
        javalangException.put(LinkageError.class.getSimpleName(), "java.lang");
        javalangException.put(NegativeArraySizeException.class.getSimpleName(), "java.lang");
        javalangException.put(NoClassDefFoundError.class.getSimpleName(), "java.lang");

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
        javalangType.put(Iterable.class.getSimpleName(), "java.lang");
        javalangType.put(Long.class.getSimpleName(), "java.lang");
        javalangType.put(Math.class.getSimpleName(), "java.lang");
        javalangType.put(Number.class.getSimpleName(), "java.lang");
        javalangType.put(Object.class.getSimpleName(), "java.lang");
        javalangType.put(Package.class.getSimpleName(), "java.lang");
        javalangType.put(Process.class.getSimpleName(), "java.lang");
        javalangType.put(ProcessBuilder.class.getSimpleName(), "java.lang");
        javalangType.put(Readable.class.getSimpleName(), "java.lang");
        javalangType.put(Runnable.class.getSimpleName(), "java.lang");
        javalangType.put(Runtime.class.getSimpleName(), "java.lang");
        javalangType.put(RuntimePermission.class.getSimpleName(), "java.lang");
        javalangType.put(SecurityManager.class.getSimpleName(), "java.lang");
        javalangType.put(Short.class.getSimpleName(), "java.lang");
        javalangType.put(StackTraceElement.class.getSimpleName(), "java.lang");
        javalangType.put(StrictMath.class.getSimpleName(), "java.lang");
        javalangType.put(String.class.getSimpleName(), "java.lang");
        javalangType.put(StringBuffer.class.getSimpleName(), "java.lang");
        javalangType.put(StringBuilder.class.getSimpleName(), "java.lang");
        javalangType.put(System.class.getSimpleName(), "java.lang");
        javalangType.put(Thread.class.getSimpleName(), "java.lang");
        javalangType.put(ThreadGroup.class.getSimpleName(), "java.lang");
        javalangType.put(ThreadLocal.class.getSimpleName(), "java.lang");
        javalangType.put(Void.class.getSimpleName(), "java.lang");

        javalangAnnotation.put(Deprecated.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(FunctionalInterface.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(Override.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(SafeVarargs.class.getSimpleName(), "java.lang");
        javalangAnnotation.put(SuppressWarnings.class.getSimpleName(), "java.lang");
    }
}
