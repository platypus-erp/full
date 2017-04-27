package org.platypus.erp.cdi.spi.front.column;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Documented
public @interface DataTableColumn {

    String entityName();
}
