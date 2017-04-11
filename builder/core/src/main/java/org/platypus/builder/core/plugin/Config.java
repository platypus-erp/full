package org.platypus.builder.core.plugin;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.plugin.model.merger.ModelMerged;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;
import org.platypus.builder.core.plugin.moduletree.ModuleTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public class Config implements PlatypusBuilderMutableConf {


    Map<String, PlatypusPlugin> mapPluginByCanonicalName = new HashMap<>();
    List<ModelProcessor> modelProcessors = new ArrayList<>();
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
        System.out.println("addPlugin "+ platypusPlugin.getName());
        mapPluginByCanonicalName.put(platypusPlugin.getClass().getCanonicalName(), platypusPlugin);
    }

    public void addModelProcessor(ModelProcessor modelProcessor){

    }
    public void initModelProcessors() {

    }

    public void initPlugins(String ... pluginsToRun) {
        mapPluginByCanonicalName.values().stream().filter(p -> Arrays.binarySearch(pluginsToRun, p.getName()) >= 0)
                .forEach(p -> p.init(this));
    }

    public void runPlugins(String ... pluginsToRun) {
        mapPluginByCanonicalName.values().stream().filter(p -> Arrays.binarySearch(pluginsToRun, p.getName()) >= 0)
                .forEach(p -> p.execute(this));
        mapPluginByCanonicalName.values().forEach(p -> p.after(this));
    }

    public void destroyPlugins(String ... pluginsToRun) {
        mapPluginByCanonicalName.values().stream().filter(p -> Arrays.binarySearch(pluginsToRun, p.getName()) >= 0)
                .forEach(p -> p.detroy(this));
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
