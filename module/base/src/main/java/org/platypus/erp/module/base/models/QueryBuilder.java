package org.platypus.erp.module.base.models;

import org.platypus.api.QueryPath;
import org.platypus.api.UnmutableGenericField;
import org.platypus.api.fields.StringField;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class QueryBuilder {

    public static Predicate eq(QueryPath column, Object value){
        Predicate pre = new Predicate();
        pre.path = column.getPath();
        pre.sqlSymbole = SqlSymbole.EQ;
        pre.value = PredicateValue.of(column, value);
        return pre;
    }

    static class Predicate{
        String  path;
        SqlSymbole sqlSymbole;
        PredicateValue value;
    }

    static class PredicateValue{

        public static PredicateValue of(QueryPath column, Object value) {
            return new PredicateValue();
        }
    }

    class QueryColumn{

    }

    enum SqlSymbole{
        EQ
    }


}
