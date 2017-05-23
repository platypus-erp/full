package org.platypus.api.query;

import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class QueryPath {
    public final String columnName;
    public final String tableName;
    QueryPath next;
    QueryPath previous;
    public final boolean isRelation;

    private QueryPath(String tableName, String columnName, boolean isRelation) {
        this.columnName = columnName;
        this.tableName = tableName;
        this.isRelation = isRelation;
    }

    public static QueryPath relation(String tableName, String column) {
        return new QueryPath(tableName, column, true);
    }

    public static QueryPath basic(String tableName, String column) {
        return new QueryPath(tableName, column, false);
    }

    public QueryPath(QueryPath path) {
        this.columnName = path.columnName;
        this.tableName = path.tableName;
        this.previous = path.previous;
        this.next = path.next;
        this.isRelation = path.isRelation;
    }


    public QueryPath resolve(QueryPath next) {
        this.next = next;
        next.previous = this;
        return next;
    }

    public Optional<QueryPath> getNext() {
        return Optional.ofNullable(next);
    }


    public Optional<QueryPath> getPrevious() {
        return Optional.ofNullable(previous);
    }


    public QueryPath reverse(){
        return recursiveReverse(this);
    }

    private QueryPath recursiveReverse(QueryPath queryPath){
        if (queryPath.previous == null){
            return queryPath;
        } else {
            return recursiveReverse(queryPath.previous);
        }
    }

    public String getTablePath(){
        String str = this.tableName;
        if (this.previous != null) {
            String previous = this.previous.getTablePath();
            if (this.isRelation){
                str = previous + "." + this.columnName;
            } else {
                str = previous;
            }
        }
        return str;
    }


    public String toString() {
        String str = this.tableName + "[" + this.columnName + "|" + isRelation + "]";
        if (this.previous != null) {
            str = this.previous.toString() + "." + str;
        }
        return str;
    }
}
