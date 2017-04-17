package org.platypus.builder.core.plugin;


import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.PluginConf;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTree;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface PlatypusBuilderImMutableConf {

    Optional<PluginConf> getPluginConfig(String pluginName);

    default PluginConf getPluginConfOrThrow(String pluginName) {
        return getPluginConfig(pluginName).orElseThrow(() -> new NoSuchElementException("no plugin " + pluginName + " defined"));
    }

    PlatypusCompleteModuleInfo getCurrentModule();

    ModuleTree getModuleTree();

    ModuleTreeModel getModelTree();

    Map<String, ModelMerged> getModelMerged();


    String getDefaultPackage();
}
