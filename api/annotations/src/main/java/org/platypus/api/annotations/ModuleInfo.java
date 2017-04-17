package org.platypus.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModuleInfo {
    String name();
    String moduleVersion();
    PlatypusVersion version() default PlatypusVersion.V1;
    String[] depends();
}
