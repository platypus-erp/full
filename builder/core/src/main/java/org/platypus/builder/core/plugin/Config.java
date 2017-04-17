package org.platypus.builder.core.plugin;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.PluginConf;
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
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public class Config implements PlatypusBuilderMutableConf {


    List<ModelProcessor> modelProcessors = new ArrayList<>();
    PlatypusCompleteModuleInfo currentModule;
    ModuleTree moduleTree;
    ModuleTreeModel moduleTreeModel;
    Map<String, ModelMerged> modelMerged;
    Map<String, PluginConf> conf;
    String defaultPkg;

    public Config(PlatypusCompleteModuleInfo currentModule,
                  ModuleTree moduleTree,
                  ModuleTreeModel moduleTreeModel,
                  Map<String, ModelMerged> modelMerged,
                  Map<String, PluginConf> conf,
                  String defaultPkg) {
        this.currentModule = currentModule;
        this.moduleTree = moduleTree;
        this.moduleTreeModel = moduleTreeModel;
        this.modelMerged = modelMerged;
        this.conf = conf;
        this.defaultPkg = defaultPkg;
    }

    @Override
    public Optional<PluginConf> getPluginConfig(String pluginName) {
        return Optional.ofNullable(conf.get(pluginName));
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

    @Override
    public String getDefaultPackage() {
        return defaultPkg;
    }
}
