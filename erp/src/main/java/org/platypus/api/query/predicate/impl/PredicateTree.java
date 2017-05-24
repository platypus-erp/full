package org.platypus.api.query.predicate.impl;

import org.platypus.api.Record;
import org.platypus.api.query.PredicateCombinator;
import org.platypus.api.query.predicate.FilterContainer;
import org.platypus.api.query.predicate.PlatypusPredicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 17/05/17.
 */
public class PredicateTree<T extends Record> {

    FilterContainer<T> filter;
    PredicateCombinator combinator;
    PredicateTree<T> next;
    PredicateTree<T> previous;

    public PredicateTree(){

    }

    private PredicateTree(FilterContainer<T> filter){
        this.filter = filter;
    }

    public PredicateTree<T> and(){
        this.combinator = PredicateCombinator.AND;
        return this;
    }
    public PredicateTree<T> or(){
        this.combinator = PredicateCombinator.OR;
        return this;
    }

    public PredicateTree<T> addNext(FilterContainer<T> filter){
        PredicateTree<T> predicateTree = new PredicateTree<>(filter);
        if (this.filter != null){
            this.next = predicateTree;
            predicateTree.previous = this;
        }
        return predicateTree;
    }

    public FilterContainer<T> getFilter() {
        return filter;
    }

    public PredicateCombinator getCombinator() {
        return combinator;
    }

    public PredicateTree<T> getNext() {
        return next;
    }

    public PredicateTree<T> getPrevious() {
        return previous;
    }
}
