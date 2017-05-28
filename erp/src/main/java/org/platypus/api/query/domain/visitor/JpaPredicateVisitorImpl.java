package org.platypus.api.query.domain.visitor;

import org.platypus.api.Record;
import org.platypus.api.query.domain.DomainCombinator;
import org.platypus.api.query.domain.field.BigStringFieldPredicate;
import org.platypus.api.query.domain.field.BinaryFieldPredicate;
import org.platypus.api.query.domain.field.BooleanFieldPredicate;
import org.platypus.api.query.domain.field.DateFieldPredicate;
import org.platypus.api.query.domain.field.DateTimeFieldPredicate;
import org.platypus.api.query.domain.field.DecimalFieldPredicate;
import org.platypus.api.query.domain.field.FloatFieldPredicate;
import org.platypus.api.query.domain.field.IntFieldPredicate;
import org.platypus.api.query.domain.field.LongFieldPredicate;
import org.platypus.api.query.domain.field.StringFieldPredicate;
import org.platypus.api.query.domain.field.TimeFieldPredicate;
import org.platypus.api.query.domain.visitor.domain.Domain;
import org.platypus.api.query.domain.visitor.domain.GroupDomain;
import org.platypus.api.query.domain.visitor.field.BigStringValuePredicate;
import org.platypus.api.query.domain.visitor.field.BinaryValuePredicate;
import org.platypus.api.query.domain.visitor.field.BooleanValuePredicate;
import org.platypus.api.query.domain.visitor.field.DateTimeValuePredicate;
import org.platypus.api.query.domain.visitor.field.DateValuePredicate;
import org.platypus.api.query.domain.visitor.field.DecimalValuePredicate;
import org.platypus.api.query.domain.visitor.field.FloatValuePredicate;
import org.platypus.api.query.domain.visitor.field.IntValuePredicate;
import org.platypus.api.query.domain.visitor.field.LongValuePredicate;
import org.platypus.api.query.domain.visitor.field.RecordValuePredicate;
import org.platypus.api.query.domain.visitor.field.StringValuePredicate;
import org.platypus.api.query.domain.visitor.field.TimeValuePredicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class JpaPredicateVisitorImpl<T extends Record> implements PredicateVisitor<T> {

    Predicate currentPredicate;
    List<Predicate> andGroups = new ArrayList<>();
    Predicate currentAndGroup;
    CriteriaBuilder cb;
    T instance;
    Map<String, From<?, ?>> tableJoin;
    From<?, ?> from;
    PredicateBuilder predicateBuilder;


    @Override
    public void visit(Domain<T> element) {
        element.getPredicate1().ifPresent(r -> r.accept(this));
        element.getPredicate1().ifPresent(r -> r.accept(this));
        element.getCombinator1().ifPresent(r -> r.accept(this));
        element.getPredicate2().ifPresent(r -> r.accept(this));
        element.getCombinator2().ifPresent(r -> r.accept(this));
        element.getPredicate3().ifPresent(r -> r.accept(this));
        element.getCombinator3().ifPresent(r -> r.accept(this));
        element.getPredicate4().ifPresent(r -> r.accept(this));
        element.getCombinator4().ifPresent(r -> r.accept(this));
        element.getPredicate5().ifPresent(r -> r.accept(this));
        element.getCombinator5().ifPresent(r -> r.accept(this));
        element.getPredicate6().ifPresent(r -> r.accept(this));
        element.getCombinator6().ifPresent(r -> r.accept(this));
        element.getPredicate7().ifPresent(r -> r.accept(this));
        element.getCombinator7().ifPresent(r -> r.accept(this));
        element.getPredicate8().ifPresent(r -> r.accept(this));
        element.getCombinator8().ifPresent(r -> r.accept(this));
        element.getPredicate9().ifPresent(r -> r.accept(this));
        element.getCombinator9().ifPresent(r -> r.accept(this));
        element.getPredicate10().ifPresent(r -> r.accept(this));
        element.getCombinator10().ifPresent(r -> r.accept(this));
        element.getPredicate11().ifPresent(r -> r.accept(this));
        element.getCombinator11().ifPresent(r -> r.accept(this));
        element.getPredicate12().ifPresent(r -> r.accept(this));
        element.getCombinator12().ifPresent(r -> r.accept(this));
        element.getPredicate13().ifPresent(r -> r.accept(this));
        element.getCombinator13().ifPresent(r -> r.accept(this));
        element.getPredicate14().ifPresent(r -> r.accept(this));
        element.getCombinator14().ifPresent(r -> r.accept(this));
        element.getPredicate15().ifPresent(r -> r.accept(this));
        element.getCombinator15().ifPresent(r -> r.accept(this));
        element.getPredicate16().ifPresent(r -> r.accept(this));
        element.getCombinator16().ifPresent(r -> r.accept(this));
        element.getPredicate17().ifPresent(r -> r.accept(this));
        element.getCombinator17().ifPresent(r -> r.accept(this));
        element.getPredicate18().ifPresent(r -> r.accept(this));
        element.getCombinator18().ifPresent(r -> r.accept(this));
        element.getPredicate19().ifPresent(r -> r.accept(this));
        element.getCombinator19().ifPresent(r -> r.accept(this));
        element.getPredicate20().ifPresent(r -> r.accept(this));
    }

    @Override
    public void visit(BinaryValuePredicate element) {
        element = Objects.requireNonNull(element);


        BinaryFieldPredicate field = element.getField();
        Path<byte[]> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateNullOrNotNull(path1, element.getCondition());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(BigStringValuePredicate element) {
        element = Objects.requireNonNull(element);


        BigStringFieldPredicate field = element.getField();
        Path<String> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateNullOrNotNull(path1, element.getCondition());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(BooleanValuePredicate element) {
        element = Objects.requireNonNull(element);

        BooleanFieldPredicate field = element.getField();
        Path<Boolean> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateEq(path1, element.getCondition(), element.getValue());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(DateTimeValuePredicate element) {
        element = Objects.requireNonNull(element);

        DateTimeFieldPredicate field = element.getField();
        Path<LocalDateTime> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(DateValuePredicate element) {
        element = Objects.requireNonNull(element);

        DateFieldPredicate field = element.getField();
        Path<LocalDate> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(DecimalValuePredicate element) {
        element = Objects.requireNonNull(element);

        DecimalFieldPredicate field = element.getField();
        Path<BigDecimal> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        if (pre == null) {
            pre = predicateBuilder.getPredicateIn(path1, element.getCondition(), element.getValuesIn());
        }
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(FloatValuePredicate element) {
        element = Objects.requireNonNull(element);

        FloatFieldPredicate field = element.getField();
        Path<Float> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        if (pre == null) {
            pre = predicateBuilder.getPredicateIn(path1, element.getCondition(), element.getValuesIn());
        }
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(IntValuePredicate element) {
        element = Objects.requireNonNull(element);

        IntFieldPredicate field = element.getField();
        Path<Integer> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        if (pre == null) {
            pre = predicateBuilder.getPredicateIn(path1, element.getCondition(), element.getValuesIn());
        }
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(LongValuePredicate element) {
        element = Objects.requireNonNull(element);

        LongFieldPredicate field = element.getField();
        Path<Long> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        if (pre == null) {
            pre = predicateBuilder.getPredicateIn(path1, element.getCondition(), element.getValuesIn());
        }
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(RecordValuePredicate element) {

    }

    @Override
    public void visit(StringValuePredicate element) {
        element = Objects.requireNonNull(element);

        StringFieldPredicate field = element.getField();
        Path<String> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateIn(path1, element.getCondition(), element.getValuesIn());
        if (pre != null) {
            currentPredicate = pre;
            return;
        }
        switch (element.getCondition()) {
            case I_EQ:
                pre = cb.equal(cb.upper(path1), element.getValue().toUpperCase());
                break;
            case I_NOT_EQ:
                pre = cb.notEqual(cb.upper(path1), element.getValue().toUpperCase());
                break;
            case LIKE:
                pre = cb.like(path1, element.getValue());
                break;
            case I_LIKE:
                pre = cb.like(cb.upper(path1), element.getValue().toUpperCase());
                break;
            case NOT_LIKE:
                pre = cb.notLike(cb.upper(path1), element.getValue().toUpperCase());
                break;
            case NOT_I_LIKE:
                pre = cb.notLike(cb.upper(path1), element.getValue().toUpperCase());
                break;
            case I_IN:
                pre = cb.upper(path1).in(element.getValuesIn().stream()
                        .map(String::toUpperCase).collect(Collectors.toSet()));
                break;
            case I_NOT_IN:
                pre = cb.upper(path1).in(element.getValuesIn().stream()
                        .map(String::toUpperCase).collect(Collectors.toSet())).not();
            default:
                pre = null;
        }
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }


    @Override
    public void visit(TimeValuePredicate element) {
        element = Objects.requireNonNull(element);

        TimeFieldPredicate field = element.getField();
        Path<LocalTime> path1 = p2j.getJoin(field.getPath().reverse(), tableJoin, from).get(field.getPath().columnName);
        Predicate pre = predicateBuilder.getPredicateComparable(
                path1, element.getCondition(), element.getValue(), element.getValue2());
        currentPredicate = predicateBuilder.requiredNonNull(element.getCondition(), field.getPath().toString(), pre);
    }

    @Override
    public void visit(GroupDomain element) {
        JpaPredicateVisitorImpl visitor = new JpaPredicateVisitorImpl();
        element.getPredicate().accept(visitor);
        element.getCombinator().accept(visitor);
        element.getNext().accept(visitor);
        currentPredicate = visitor.buildPredicate();
    }

    @Override
    public void visit(DomainCombinator predicateCombinator) {
        switch (predicateCombinator) {
            case OR:
                if (currentAndGroup == null) {
                    currentAndGroup = currentPredicate;
                } else {
                    currentAndGroup = cb.and(currentAndGroup, currentPredicate);
                }
                andGroups.add(currentAndGroup);
                currentAndGroup = null;
                break;
            case AND:
                if (currentAndGroup == null) {
                    currentAndGroup = currentPredicate;
                } else {
                    currentAndGroup = cb.and(currentAndGroup, currentPredicate);
                }
                break;
        }
    }

    public Predicate buildPredicate() {
        if (currentAndGroup == null) {// the last combinator is an OR
            andGroups.add(currentPredicate);
        } else {
            andGroups.add(cb.and(currentAndGroup, currentPredicate));
        }
        return cb.or(andGroups.toArray(new Predicate[andGroups.size()]));
    }
}
