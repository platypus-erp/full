package org.platypus.erp.module.base.models;


import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/05/17.
 */
public class LazyJoinField<R, T>{

    Root<R> root;
    String name;
    public LazyJoinField(String name, Root<R> root) {
    }

    public T join(){
        return root.join(name);
    }


}
