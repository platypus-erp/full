package org.platypus.builder.core.plugin.moduletree;

import org.platypus.api.module.ModuleInfo;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public interface ModuleTreeNode {

    ModuleInfo info();

    Set<ModuleTreeNode> getChildren();
}
