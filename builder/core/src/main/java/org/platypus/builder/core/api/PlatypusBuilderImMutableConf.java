package org.platypus.builder.core.api;


import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.PluginConf;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.moduletree.ModuleTree;

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
        return getPluginConfig(pluginName).orElseThrow(() -> new NoSuchElementException("no api " + pluginName + " defined"));
    }

    PlatypusCompleteModuleInfo getCurrentModule();

    ModuleTree getModuleTree();

    ModelTree getModelTree();

    ModelsMerged getModelMerged();


    String getDefaultPackage();

    MetaInfoRecord getRecord(String name);

    MetaInfoRecordCollection getRecordCollection(String name);
}
