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

    public QueryPath(String columnName, String tableName) {
        this.columnName = columnName;
        this.tableName = tableName;
    }

    public QueryPath(QueryPath path) {
        this.columnName = path.columnName;
        this.tableName = path.tableName;
        this.previous = path.previous;
        this.next = path.next;
    }

    
    public QueryPath resolve(QueryPath next) {
        this.next = next;
        next.previous = this;
        return next;
    }

    public QueryPath resolve(String columnName, String tableName) {
        return resolve(new QueryPath(columnName, tableName));
    }
    
    public Optional<QueryPath> getNext() {
        return Optional.ofNullable(next);
    }

    
    public Optional<QueryPath> getPrevious() {
        return Optional.ofNullable(previous);
    }

    
    public String getColumnName() {
        return columnName;
    }

    
    public String getTableName() {
        return tableName;
    }

    
    public boolean isRelation() {
        return true;
    }

    
    public String toString() {
        return (this.previous != null && !this.previous.toString().isEmpty() ? this.previous.toString()+ "." : "") + this.tableName+"["+this.columnName+"]";
    }
}
