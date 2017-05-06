package org.platypus.builder.core.model.tree;


import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.builder.core.api.TreeNode;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface ModelTreeNode extends TreeNode<ModelTreeNode, MetaInfoModel>{

    default String getName() {
        return getInfo().getName();
    }
}
