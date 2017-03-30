package org.platypus.builder.core.plugin;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public class Config implements PlatypusBuilderMutableConf {


    Map<String, PlatypusPlugin> mapPluginByCanonicalName = new HashMap<>();
    PlatypusCompleteModuleInfo currentModule;
    ModuleTree moduleTree;
    ModuleTreeModel moduleTreeModel;
    Map<String, ModelMerged> modelMerged;

    public Config(PlatypusCompleteModuleInfo currentModule, ModuleTree moduleTree, ModuleTreeModel moduleTreeModel, Map<String, ModelMerged> modelMerged) {
        this.currentModule = currentModule;
        this.moduleTree = moduleTree;
        this.moduleTreeModel = moduleTreeModel;
        this.modelMerged = modelMerged;
    }

    public void addPlugin(PlatypusPlugin platypusPlugin){
        mapPluginByCanonicalName.put(platypusPlugin.getClass().getCanonicalName(), platypusPlugin);
    }
    public void initPlugins() {
        mapPluginByCanonicalName.values().forEach(p -> p.init(this));
    }

    @Override
    public Optional<PlatypusPlugin> getPlugin(Class<PlatypusPlugin> type) {
        return Optional.ofNullable(mapPluginByCanonicalName.get(type.getCanonicalName()));
    }

    @Override
    public PlatypusCompleteModuleInfo getCurrentModule() {
        return currentModule;
    }

    @Override
    public ModuleTree getModuleTree() {
        return moduleTree;
    }

    @Override
    public ModuleTreeModel getModelTree() {
        return moduleTreeModel;
    }

    @Override
    public Map<String, ModelMerged> getModelMerged() {
        return modelMerged;
    }
}
