package org.platypus.api.query.domain.visitor.field;

import org.platypus.api.query.QueryPath;
import org.platypus.api.query.domain.field.StringFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;
import org.platypus.api.query.domain.visitor.PredicateVisitor;

/**
 * @author chmuchme
 * @since 0.1
 * on 26/05/17.
 */
public class RecordValuePredicate implements PPredicate {

    public enum StringDomainAttribute {
        CASE_SENSITIVE(0x00000001),
        CASE_INSENSITIVE(0x00000002),
        NOT(0x00000004),
        OR_NULL(0x00000100);

        int value;

        StringDomainAttribute(int value) {
            this.value = value;
        }

        public static boolean contains(int value, StringDomainAttribute att){
            return (value & att.value) != 0;
        }
    }

    StringFieldPredicate field;
    String value;
    StringDomainAttribute[] attribute;

    public QueryPath getPath() {
        return field.getPath();
    }

    public QueryPath resolve(QueryPath queryPath) {
        return field.resolve(queryPath);
    }

    public RecordValuePredicate(StringFieldPredicate field,
                                String value,
                                StringDomainAttribute... attribute) {
        this.field = field;
        this.value = value;
        this.attribute = attribute;
    }

    @Override
    public void accept(PredicateVisitor predicateVisitor) {
        predicateVisitor.visit(this);
    }
}
