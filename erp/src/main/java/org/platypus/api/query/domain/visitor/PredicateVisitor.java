package org.platypus.api.query.domain.visitor;

import org.platypus.api.Record;
import org.platypus.api.query.Domain;
import org.platypus.api.query.VisitorInitializer;
import org.platypus.api.query.domain.visitor.domain.DomainContainer;
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

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public interface PredicateVisitor<T extends Record, INIT extends VisitorInitializer> {

    void initWith(INIT init);

    void visit(BinaryValuePredicate element);
    void visit(BigStringValuePredicate element);
    void visit(BooleanValuePredicate element);
    void visit(DateTimeValuePredicate element);
    void visit(DateValuePredicate element);
    void visit(DecimalValuePredicate element);
    void visit(FloatValuePredicate element);
    void visit(IntValuePredicate element);
    void visit(LongValuePredicate element);
    void visit(RecordValuePredicate element);
    void visit(StringValuePredicate element);
    void visit(TimeValuePredicate element);
    void visit(GroupDomain element);
    void visit(DomainContainer<T> element);

    void visit(Domain.DomainCombinator predicateCombinator);
}
