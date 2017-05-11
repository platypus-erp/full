package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.fields.StringField;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/05/17.
 */
public class PredicateStep {


    public final StringPredicate and(StringField field){
        return new StringPredicate(true,field, this);
    }

    public final StringPredicate or(StringField field){
        return new StringPredicate(false,field, this);
    }

    public <R extends Record> SearchResult<R> execute(R rec) {
        return null;
    }
}
