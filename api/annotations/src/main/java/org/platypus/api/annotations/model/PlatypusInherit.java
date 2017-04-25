package org.platypus.api.annotations.model;

import org.platypus.api.BaseModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlatypusInherit {
    Class<? extends BaseModel> values();
}
