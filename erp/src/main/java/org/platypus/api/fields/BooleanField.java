package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.BooleanFieldPredicate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface BooleanField extends PlatypusField<Boolean>, BooleanFieldPredicate {

    static BooleanField of(boolean value) {
        return null;
    }

    static BooleanField True() {
        return null;
    }
    static BooleanField False() {
        return null;
    }


}
