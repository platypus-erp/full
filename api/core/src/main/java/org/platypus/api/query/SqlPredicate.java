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
    OR("or"),
    AND("and")
    ;

    public final String sql;

    SqlPredicate(String sql) {
        this.sql = sql;
    }
}
