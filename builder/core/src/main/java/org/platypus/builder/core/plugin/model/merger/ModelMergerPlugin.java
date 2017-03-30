package org.platypus.builder.core.plugin.model.merger;


import org.platypus.builder.core.plugin.model.merger.internal.ModelMerger;
import org.platypus.builder.core.plugin.model.tree.ModelTreePluginApi;
import org.platypus.builder.core.plugin.model.tree.ModuleTreeModel;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelMergerPlugin {

    public String name() {
        return "model-merger";
    }

    private Map<String, ModelMerger> modelsMerger = new HashMap<>();
    private Map<String, ModelMerged> modelsMerged = new HashMap<>();
    private final ModuleTreeModel tree;

    public ModelMergerPlugin(ModuleTreeModel tree) {
        this.tree = tree;
    }

    public Map<String, ModelMerged> getModel() {
        return modelsMerged;
    }

    public Map<String, ModelMerged> build() {
        tree.getAllModel().forEach(mt -> modelsMerger.compute(mt.getName(), (k,v) -> ModelMerger.combine(v, mt)));
        modelsMerged = modelsMerger.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey, v -> v.getValue().toMerged()));
        return modelsMerged;
    }
}
