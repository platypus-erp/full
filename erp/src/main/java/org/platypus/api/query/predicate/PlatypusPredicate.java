package org.platypus.api.query.predicate;

/**
 * Created by apasquier on 17/05/17.
 */
public interface PlatypusPredicate<LEFT, CONDITION, RIGHT> {

    LEFT getLeft();

    CONDITION getCondition();

    RIGHT getRight();
}
