package org.platypus.builder.core.plugin.moduletree;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public interface ModuleTree {

    ModuleTreeNode getBase();
    ModuleTreeNode getModule(String moduleName);
    Set<ModuleTreeNode> getAllModule();
    Set<String> getAllModuleName();
}
