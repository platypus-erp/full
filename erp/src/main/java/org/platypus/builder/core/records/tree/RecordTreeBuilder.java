package org.platypus.builder.core.records.tree;

import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.records.tree.impl.RecordTreeImpl;

/**
 * @author chmuchme
 * @since 0.1
 * on 05/05/17.
 */
public class RecordTreeBuilder {

    RecordTreeImpl tree;
    public RecordTree build(ModelTree modelTree){
        tree = new RecordTreeImpl();
        tree.calculateTreeModel(modelTree);
        return tree;
    }

    public static RecordTreeImpl emptyTree(){
        return new RecordTreeImpl();
    }

    public RecordTree getTree() {
        return tree;
    }
}
