package org.platypus.api.query.domain.field;

import org.platypus.api.Record;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface RecordFieldPredicate<T extends RecordFieldPredicate<T> & Record> extends FieldPredicate {


    PPredicate in(Collection<T> values);

    PPredicate in(T... values);
}
