package org.platypus.builder.core.api;

import org.platypus.api.Namable;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.builder.core.model.tree.ModelTreeNode;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public interface TreeNode<T extends TreeNode<T, M>, M> extends Namable{

    M getInfo();
    Set<T> getChildren();
    Set<T> getParent();
}
