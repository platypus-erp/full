package org.platypus.builder.core.views.list.generator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@Documented
public @interface PolymereWebComponennt {

    String name();
    String linkDoc();
}
