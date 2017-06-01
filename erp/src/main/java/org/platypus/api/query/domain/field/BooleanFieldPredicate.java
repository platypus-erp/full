package org.platypus.api.query.domain.field;

import org.platypus.api.Pathable;
import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.visitor.PPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface BooleanFieldPredicate extends Pathable, PlatypusField<Boolean> {

    PPredicate eq(Boolean value);
    PPredicate isTrue();
    PPredicate isFalse();
}
