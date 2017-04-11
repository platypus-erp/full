package org.platypus.plugin.displaytreemodule;

import org.apache.commons.lang3.StringUtils;
import org.platypus.builder.core.plugin.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.plugin.PlatypusBuilderMutableConf;
import org.platypus.builder.core.plugin.PlatypusPlugin;
import org.platypus.builder.core.plugin.moduletree.ModuleTreeNode;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
public class DisplayTreeModuleTxt implements PlatypusPlugin {
    @Override
    public String getName() {
        return "display-tree-module-txt";
    }

    @Override
    public void init(PlatypusBuilderMutableConf conf) {

    }

    @Override
    public void execute(PlatypusBuilderImMutableConf conf) {
        System.out.println("Run of "+ getName());
        System.out.println(conf.getModuleTree().getBase().info().techincalName());
        displayDepends(conf.getModuleTree().getBase(), 0);
    }

    private void displayDepends(ModuleTreeNode moduleTreeNode, int level) {
        level++;
        for (ModuleTreeNode child : moduleTreeNode.getChildren()) {
            System.out.println(StringUtils.repeat("-", level) + "> " + child.info().techincalName());
            displayDepends(child, level);
        }
    }
}
