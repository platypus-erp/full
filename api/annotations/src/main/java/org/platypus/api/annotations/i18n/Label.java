package org.platypus.api.annotations.i18n;

import java.lang.annotation.Repeatable;

/**
 * @author chmuchme
 * @since 0.1
 * on 29/03/17.
 */
@Repeatable(LabelRepeatable.class)
public @interface Label {

    String value();
    String key() default "";
    String lang() default "";
}
