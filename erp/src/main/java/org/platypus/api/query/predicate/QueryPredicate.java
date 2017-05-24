package org.platypus.api.query.predicate;

import org.platypus.api.PlatypusField;
import org.platypus.api.fields.FieldType;
import org.platypus.api.query.SqlPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public interface QueryPredicate<T extends PlatypusField> extends PlatypusPredicate<T, SqlPredicate, T>{

    FieldType getFieldType();

}
