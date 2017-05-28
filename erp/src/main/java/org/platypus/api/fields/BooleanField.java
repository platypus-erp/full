package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.domain.DomainPredicate;
import org.platypus.api.query.domain.field.BooleanFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface BooleanField extends GenericField<Boolean>, BooleanFieldPredicate {

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
