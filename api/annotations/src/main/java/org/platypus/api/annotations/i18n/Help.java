package org.platypus.api.annotations.i18n;

import java.lang.annotation.Repeatable;

/**
 * @author chmuchme
 * @since 0.1
 * on 29/03/17.
 */
@Repeatable(HelpRepeatable.class)
public @interface Help {

    String value();
    String key() default "";
    String lang() default "";
}
