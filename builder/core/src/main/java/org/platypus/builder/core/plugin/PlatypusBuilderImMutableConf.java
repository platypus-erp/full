package org.platypus.builder.core.plugin;


import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.PlatypusPlugin;
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

    Optional<PlatypusPlugin> getPlugin(Class<PlatypusPlugin> type);

    default PlatypusPlugin getPluginOrThrow(Class<PlatypusPlugin> type) {
        return getPlugin(type).orElseThrow(() -> new NoSuchElementException("no plugin " + type.getCanonicalName() + " defined"));
    }

    PlatypusCompleteModuleInfo getCurrentModule();

    ModuleTree getModuleTree();

    ModuleTreeModel getModelTree();

    Map<String, ModelMerged> getModelMerged();


}
