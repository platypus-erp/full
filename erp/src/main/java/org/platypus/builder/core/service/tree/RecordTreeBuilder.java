package org.platypus.builder.core.service.tree;

import org.platypus.builder.core.service.tree.impl.BusinessTreeImpl;
import org.platypus.builder.core.model.tree.ModelTree;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/05/17.
 */
public class RecordTreeBuilder {

    BusinessTreeImpl tree;
    public BusinessTree build(ModelTree modelTree){
        tree = new BusinessTreeImpl();
        tree.calculateTreeModel(modelTree);
        return tree;
    }

    public static BusinessTreeImpl emptyTree(){
        return new BusinessTreeImpl();
    }

    public BusinessTree getTree() {
        return tree;
    }
}
