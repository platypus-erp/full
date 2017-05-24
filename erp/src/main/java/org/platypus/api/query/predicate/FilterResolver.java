package org.platypus.api.query.predicate;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.fields.BigStringField;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.DateField;
import org.platypus.api.fields.DateTimeField;
import org.platypus.api.fields.DecimalField;
import org.platypus.api.fields.FieldType;
import org.platypus.api.fields.FloatField;
import org.platypus.api.fields.IntField;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.TimeField;
import org.platypus.api.query.PredicateCombinator;

import java.util.List;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/05/17.
 */
public class FilterResolver<T extends Record> {
    Map<FieldType, Map<String, QueryPredicate<? extends PlatypusField<?>>>> predicate;
    List<String> order;
    Map<String, FieldType> orderType;
    Map<String, PredicateCombinator> orderCombinator;

    public FilterResolver(T instance, FilterContainer<T> container) {


    }

    private void addToMap(QueryPredicate<? extends PlatypusField<?>> predicate) {
        Map<String, QueryPredicate<? extends PlatypusField<?>>> val = this.predicate.get(predicate.getFieldType());
        val.put(predicate.getLeft().getPath().toString(), predicate);
        order.add(predicate.getLeft().getPath().toString());
    }

    public FieldType getType(String order) {
        return orderType.get(order);
    }
    public PredicateCombinator getCombinator(String order) {
        return orderCombinator.get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<BigStringField> getBigString(String order) {
        return (QueryPredicate<BigStringField>) predicate.get(FieldType.BIG_STRING).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<BinaryField> getBinary(String order) {
        return (QueryPredicate<BinaryField>) predicate.get(FieldType.BINARY).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<BooleanField> getBoolean(String order) {
        return (QueryPredicate<BooleanField>) predicate.get(FieldType.BOOLEAN).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<DateField> getDate(String order) {
        return (QueryPredicate<DateField>) predicate.get(FieldType.DATE).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<DateTimeField> getDateTime(String order) {
        return (QueryPredicate<DateTimeField>) predicate.get(FieldType.DATE_TIME).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<DecimalField> getDecimal(String order) {
        return (QueryPredicate<DecimalField>) predicate.get(FieldType.DECIMAL).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<FloatField> getFloat(String order) {
        return (QueryPredicate<FloatField>) predicate.get(FieldType.FLOAT).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<IntField> getInt(String order) {
        return (QueryPredicate<IntField>) predicate.get(FieldType.INT).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<LongField> getLong(String order) {
        return (QueryPredicate<LongField>) predicate.get(FieldType.LONG).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<StringField> getString(String order) {
        return (QueryPredicate<StringField>) predicate.get(FieldType.STRING).get(order);
    }

    @SuppressWarnings("unchecked")
    public QueryPredicate<TimeField> getTime(String order) {
        return (QueryPredicate<TimeField>) predicate.get(FieldType.TIME).get(order);
    }

    public List<String> getOrder() {
        return order;
    }
}
