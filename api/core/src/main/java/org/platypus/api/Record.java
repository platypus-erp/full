package org.platypus.api;


import org.platypus.api.fields.LongField;

public interface Record extends Pathable,SetPathable, Booleanable, EmptyCheckable{

    LongField id();

    default <T extends Record> T unWrap(Class<T> type){
        if (type != this.getClass()) {
            throw new IllegalArgumentException("the unwrap type is wrong expected [" + this.getClass().getName() + "] actual [" + type.getName() + "]");
        }
        return (T) this;
    }
}
