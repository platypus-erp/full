package org.platypus.api.query;

import org.platypus.api.PlatypusField;
import org.platypus.api.fields.BigStringField;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.DateField;
import org.platypus.api.fields.DateTimeField;
import org.platypus.api.fields.DecimalField;
import org.platypus.api.fields.FloatField;
import org.platypus.api.fields.IntField;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.TimeField;
import org.platypus.api.query.predicate.QueryPredicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/05/17.
 */
public class PlatypusToJpa {
    private final CriteriaBuilder cb;

    public PlatypusToJpa(CriteriaBuilder cb) {
        this.cb = cb;
    }

    Predicate binaryToPredicate(
                                QueryPredicate<BinaryField> node,
                                Map<String, From<?, ?>> tableJoin,
                                From<?, ?> from) {
        if (node == null) {
            return null;
        }
        BinaryField field = node.getRight();
        Path<byte[]> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        if (!node.getLeft().isEmpty()) {
            //TODO Add log warning un used value
        }
        return getPredicateNullOrNotNull(node, path1);
    }

    Predicate bigStringToPredicate(
                                   QueryPredicate<BigStringField> node,
                                   Map<String, From<?, ?>> tableJoin,
                                   From<?, ?> from) {
        if (node == null) {
            return null;
        }
        BigStringField field = node.getRight();
        Path<String> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        if (!node.getLeft().isEmpty()) {
            //TODO Add log warning un used value
        }
        Predicate pre = getPredicateNullOrNotNull(node, path1);
        return throwIfPredicateNull(node, pre);
    }

    Predicate booleanToPredicate(
                                 QueryPredicate<BooleanField> node,
                                 Map<String, From<?, ?>> tableJoin,
                                 From<?, ?> from) {
        if (node == null) {
            return null;
        }
        BooleanField field = node.getRight();
        Path<Boolean> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate dateToPredicate(
                              QueryPredicate<DateField> node,
                              Map<String, From<?, ?>> tableJoin,
                              From<?, ?> from) {
        if (node == null) {
            return null;
        }
        DateField field = node.getRight();
        Path<LocalDate> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate dateTimeToPredicate(
                                  QueryPredicate<DateTimeField> node,
                                  Map<String, From<?, ?>> tableJoin,
                                  From<?, ?> from) {
        if (node == null) {
            return null;
        }
        DateTimeField field = node.getRight();
        Path<LocalDateTime> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate decimalToPredicate(
                                 QueryPredicate<DecimalField> node,
                                 Map<String, From<?, ?>> tableJoin,
                                 From<?, ?> from) {
        if (node == null) {
            return null;
        }
        DecimalField field = node.getRight();
        Path<BigDecimal> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateNumber(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate floatToPredicate(
                               QueryPredicate<FloatField> node,
                               Map<String, From<?, ?>> tableJoin,
                               From<?, ?> from) {
        if (node == null) {
            return null;
        }
        FloatField field = node.getRight();
        Path<Float> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateNumber(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate intToPredicate(
                             QueryPredicate<IntField> node,
                             Map<String, From<?, ?>> tableJoin,
                             From<?, ?> from) {
        if (node == null) {
            return null;
        }
        IntField field = node.getRight();
        Path<Integer> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateNumber(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate longToPredicate(
                              QueryPredicate<LongField> node,
                              Map<String, From<?, ?>> tableJoin,
                              From<?, ?> from) {
        if (node == null) {
            return null;
        }
        LongField field = node.getRight();
        Path<Long> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateNumber(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate stringToPredicate(
                                QueryPredicate<StringField> node,
                                Map<String, From<?, ?>> tableJoin,
                                From<?, ?> from) {
        if (node == null) {
            return null;
        }
        StringField field = node.getRight();
        Path<String> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateLike(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }

    Predicate timeToPredicate(
                              QueryPredicate<TimeField> node,
                              Map<String, From<?, ?>> tableJoin,
                              From<?, ?> from) {
        if (node == null) {
            return null;
        }
        TimeField field = node.getRight();
        Path<LocalTime> path1 = getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);

        Predicate pre = getPredicateNullOrNotNull(node, path1);
        pre = getPredicateEq(pre, path1, node.getCondition(), node.getRight());
        pre = getPredicateComparable(pre, path1, node.getCondition(), node.getRight());
        return throwIfPredicateNull(node, pre);
    }



    private Predicate throwIfPredicateNull(QueryPredicate<?> node, Predicate pre) {
        if (pre == null) {
            throw new UnsupportedOperationException(
                    "The predicate " + node.getCondition() + " is not Supported for the type" + node.getFieldType());
        }
        return pre;
    }

    private Predicate getPredicateNullOrNotNull( QueryPredicate<?> node, Path<?> path1) {
        switch (node.getCondition()) {
            case IS_NULL:
                return cb.isNull(path1);
            case IS_NOT_NULL:
                return cb.isNotNull(path1);
            default:
                return null;
        }
    }

    private Predicate getPredicateEq(Predicate pre,
                              Path<?> path1, SqlPredicate condition, PlatypusField<?> node) {
        if (pre != null) {
            return pre;
        }
        switch (condition) {
            case EQ:
                return cb.equal(path1, node.get());
            case NOT_EQ:
                return cb.notEqual(path1, node.get());
            default:
                return null;
        }

    }

    private <T extends Number> Predicate getPredicateNumber(Predicate pre,
                                                    
                                                    Path<T> path1,
                                                    SqlPredicate condition,
                                                    PlatypusField<T> node) {
        if (pre != null) {
            return pre;
        }
        switch (condition) {
            case LESS:
                return cb.lt(path1, node.get());
            case LESS_EQ:
                return cb.le(path1, node.get());
            case MORE:
                return cb.gt(path1, node.get());
            case MORE_EQ:
                return cb.ge(path1, node.get());
            default:
                return null;
        }
    }

    private <Y extends Comparable<? super Y>> Predicate getPredicateComparable(Predicate pre,
                                                                       
                                                                       Path<Y> path1,
                                                                       SqlPredicate condition,
                                                                       PlatypusField<Y> node) {
        if (pre != null) {
            return pre;
        }
//        switch (condition) {
//            case BETWEEN:
//                return cb.between(path1, node.get());
//            case LESS_EQ:
//                return cb.le(path1, node.get());
//            case MORE:
//                return cb.gt(path1, node.get());
//            case MORE_EQ:
//                return cb.ge(path1, node.get());
//            default:
//                return null;
//        }
//        throw new UnsupportedOperationException(
//                "The predicate " + condition + " is not Supported for the type" +fieldType);
        return null;
    }

    private Predicate getPredicateLike(Predicate pre,
                                       
                                       Path<String> path1,
                                       SqlPredicate condition,
                                       StringField right) {
        if (pre != null) {
            return pre;
        }
        switch (condition) {
            case LIKE:
                return cb.like(path1, right.get());
            case NOT_LIKE:
                return cb.like(path1, right.get());
            default:
                return null;
        }
    }


    From<?, ?> getJoin(QueryPath path, Map<String, From<?, ?>> tableJoin, From<?, ?> from) {
        From<?, ?> j = tableJoin.get(path.getTablePath());
        if (j == null) {
            j = from.join(path.columnName);
            tableJoin.putIfAbsent(path.getTablePath(), j);
        }
        if (path.isRelation && path.next != null) {
            j = getJoin(path.next, tableJoin, j);
        }
        return j;
    }
}
