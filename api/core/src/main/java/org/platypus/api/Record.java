package org.platypus.api;


public interface Record {

    default <T extends Record> T unWrap(Class<T> type){
        if (type != this.getClass()) {
            throw new IllegalArgumentException("the unwrap type is wrong expected [" + this.getClass().getName() + "] actual [" + type.getName() + "]");
        }
        return (T) this;
    }
}
