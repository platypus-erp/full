package org.platypus.erp.module.base.models;

import org.platypus.api.Pathable;
import org.platypus.api.query.QueryPath;

import java.util.Objects;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class QueryBuilder {

    public static Predicate eq(Pathable column, Object value){
        Predicate pre = new Predicate();
        pre.path = column.getPath();
        pre.sqlSymbole = SqlSymbole.EQ;
        pre.value = PredicateValue.of(column, value);
        return pre;
    }

    static class Predicate{
        QueryPath path;
        SqlSymbole sqlSymbole;
        PredicateValue value;

        @Override
        public String toString() {
            return path +" "+sqlSymbole.toSql()+" "+ value;
        }
    }

    static class PredicateValue{
        public final Object value;
        public final QueryPath path;

        private PredicateValue(Object value, QueryPath path) {
            this.value = value;
            this.path = path;
        }

        public static PredicateValue of(Pathable column, Object value) {
            return new PredicateValue(value, column.getPath());
        }

        @Override
        public String toString() {
            return Objects.toString(value);
        }
    }

    enum SqlSymbole{
        EQ("=");

        String sql;

        SqlSymbole(String sql) {
            this.sql = sql;
        }

        public String toSql() {
            return this.sql;
        }
    }


}
