package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.DateFieldPredicate;

import java.time.LocalDate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DateField extends PlatypusField<LocalDate>, DateFieldPredicate {

    static DateField empty() {
        return null;
    }

    static DateField of(LocalDate value) {
        return null;
    }

    @Override
    default LocalDate getDefaultValue() {
        return LocalDate.MIN;
    }


}
