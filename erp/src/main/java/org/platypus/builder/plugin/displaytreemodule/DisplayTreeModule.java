package org.platypus.builder.plugin.displaytreemodule;

import org.apache.commons.lang3.StringUtils;
import org.platypus.builder.core.PluginConf;
import org.platypus.builder.core.api.PlatypusBuilderImMutableConf;
import org.platypus.builder.core.api.PlatypusBuilderMutableConf;
import org.platypus.builder.core.api.PlatypusPlugin;
import org.platypus.builder.core.moduletree.ModuleTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
public class DisplayTreeModule implements PlatypusPlugin {

    PluginConf conf ;

    public DisplayTreeModule() {
        Map<String, Object> option = new HashMap<>(1);
        option.put("output", OutputType.TXT);
        this.conf = new PluginConf(getName(), option);
    }

    @Override
    public String getName() {
        return "display-tree-ui";
    }

    @Override
    public void init(PlatypusBuilderMutableConf conf) {

    }

    @Override
    public void execute(PlatypusBuilderImMutableConf conf) {
        System.out.println("Run of "+ getName());
        ModuleTreeNode module = conf.getModuleTree().getModule(conf.getCurrentModule().techincalName());
        System.out.println(module.info().techincalName());
        displayDepends(module, 0);
    }

    private void displayDepends(ModuleTreeNode moduleTreeNode, int level) {
        level++;
        for (ModuleTreeNode child : moduleTreeNode.getChildren()) {
            System.out.println(StringUtils.repeat("-", level) + "> " + child.info().techincalName());
            displayDepends(child, level);
        }
    }

    @Override
    public PluginConf getDefaultConf() {
        return this.conf;
    }

    @Override
    public void applyConf(PluginConf conf) {
        this.conf.mergeValue("output", conf);
    }
}
