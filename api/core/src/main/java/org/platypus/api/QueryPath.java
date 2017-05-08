package org.platypus.api;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class QueryPath {
    public final String name;
    private QueryPath next;
    private QueryPath previous;

    public QueryPath() {
        this("");
    }
    public QueryPath(String name) {
        this.name = name;
    }

    public QueryPath resolve(QueryPath next) {
        this.next = next;
        next.previous = this;
        return next;
    }

    public QueryPath resolve(String nextName) {
        return resolve(new QueryPath(nextName));
    }

    @Override
    public String toString() {
        return (this.previous != null && !this.previous.toString().isEmpty() ? this.previous.toString()+ "." : "") + this.name;
    }
}
