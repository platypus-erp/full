package org.platypus.api.query;

import org.platypus.api.Record;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public class SearchBuilder {
    List<QueryPath> projection = new ArrayList<>();
    QueryComplexePredicate predicate;

    public SearchBuilder() {

    }

    public SearchBuilder add(StringField field){
        return this;
    }

    public SearchBuilder add(BooleanField field){
        return this;
    }

    public SearchBuilder add(Record field){
        return this;
    }

    public SearchBuilder add(LongField field){
        return this;
    }

    public StringPredicate where(StringField field){
        return new StringPredicate(true, field, new PredicateStep());
    }

    public BooleanPredicate where(BooleanField field){
        return new BooleanPredicate(true, field, new PredicateStep());
    }






}
