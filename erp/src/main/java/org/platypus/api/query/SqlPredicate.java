package org.platypus.api.query;

/**
 * @author chmuchme
 * @since 0.1
 * on 10/05/17.
 */
public enum  SqlPredicate {
    EQ("="),
    NOT_EQ("<>"),
    IN("in"),
    NOT_IN("not in"),
    BETWEEN("between"),
    LESS("<"),
    LESS_EQ("<="),
    MORE(">"),
    MORE_EQ(">="),
    LIKE("like"),
    IS_NOT_NULL("is not null"),
    IS_NULL("is null");

    public final String sql;

    SqlPredicate(String sql) {
        this.sql = sql;
    }
}