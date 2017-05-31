package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.domain.field.StringFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.projection.PProjection;
import org.platypus.api.query.projection.ProjectionGroupVisitor;
import org.platypus.api.query.projection.ProjectionVisitor;

import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface StringField extends PlatypusField<String> {





    default boolean match(String regex){
        return match(regex, false);
    }
    default boolean match(String regex, boolean defaultValueIfEmpty){
        return isEmpty() ? defaultValueIfEmpty : this.get().matches(regex);
    }


    static StringField of(String value) {
        return null;
    }

    static StringField empty() {
        return null;
    }


}
