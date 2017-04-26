package org.platypus.builder.core.model.merger;


import org.platypus.builder.core.model.merger.internal.ModelMerger;
import org.platypus.builder.core.model.tree.ModuleTreeModel;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelMergerPlugin implements ModelsMerged{

    public String name() {
        return "model-merger";
    }

    private Map<String, ModelMerger> modelsMerger = new HashMap<>();
    private Map<String, ModelMerged> modelsMerged = new HashMap<>();
    private final ModuleTreeModel tree;

    public ModelMergerPlugin(ModuleTreeModel tree) {
        this.tree = tree;
        tree.getAllModel().forEach(mt -> modelsMerger.compute(mt.getName(), (k,v) -> ModelMerger.combine(v, mt)));
    }

    public Map<String, ModelMerged> getModel() {
        return modelsMerged;
    }

    public ModelsMerged build() {
        modelsMerged = modelsMerger.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey, v -> v.getValue().toMerged()));
        return this;
    }

    @Override
    public ModelMerged getModel(String name) {
        return modelsMerged.get(name);
    }

    @Override
    public Stream<ModelMerged> getModels() {
        return modelsMerged.values().stream();
    }

    @Override
    public Stream<String> getModelNames() {
        return modelsMerged.keySet().stream();
    }
}
