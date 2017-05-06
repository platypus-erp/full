package org.platypus.builder.core.api.impl;

import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.ModuleLoader;
import org.platypus.builder.core.PluginConf;
import org.platypus.builder.core.api.ModelProcessor;
import org.platypus.builder.core.api.PlatypusBuilderMutableConf;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.moduletree.ModuleTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public class Config implements PlatypusBuilderMutableConf {


    List<ModelProcessor> modelProcessors = new ArrayList<>();
    Map<String, PluginConf> conf;
    String defaultPkg;
    ModuleLoader moduleLoader;

    public Config(ModuleLoader moduleLoader,
                  Map<String, PluginConf> conf,
                  String defaultPkg) {
        this.moduleLoader = moduleLoader;
        this.conf = conf;
        this.defaultPkg = defaultPkg;
    }

    @Override
    public Optional<PluginConf> getPluginConfig(String pluginName) {
        return Optional.ofNullable(conf.get(pluginName));
    }

    @Override
    public PlatypusCompleteModuleInfo getCurrentModule() {
        return moduleLoader.getCurrentModule();
    }

    @Override
    public ModuleTree getModuleTree() {
        return moduleLoader.getModuleTree();
    }

    @Override
    public ModelTree getModelTree() {
        return moduleLoader.getModelTree();
    }


    @Override
    public MetaInfoRecord getRecord(String name) {
        return moduleLoader.getRecordRegistry().getMetaInfoTargetByClassName(name);
    }

    @Override
    public MetaInfoRecordCollection getRecordCollection(String name) {
        return moduleLoader.getRecordRegistry().getMetaInfoCollectionTargetByClassName(name);
    }

    @Override
    public ModelsMerged getModelMerged() {
        return moduleLoader.getModelsMerged();
    }

    @Override
    public String getDefaultPackage() {
        return defaultPkg;
    }
}
