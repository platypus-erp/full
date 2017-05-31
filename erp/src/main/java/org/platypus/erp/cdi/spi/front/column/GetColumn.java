package org.platypus.erp.cdi.spi.front.column;

import org.platypus.api.Record;

import javax.inject.Qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Qualifier
@Target({TYPE})
@Retention(RUNTIME)
@Documented
public @interface GetColumn {

    Class<? extends Record> value();
}
