package org.platypus.builder.core.field.tree.internal;


import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.api.module.ModelOfModuleInfo;
import org.platypus.builder.core.field.tree.FieldTree;
import org.platypus.builder.core.field.tree.FieldTreeApi;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.moduletree.ModuleTreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FieldTreeApiImpl implements FieldTreeApi {
    private final Map<String, ModelOfModuleInfo> modulesNodeByName;
    private Set<FieldTree> allModelTree;
    private final Map<String, FieldTreeImpl> modelsTree;

    public FieldTreeApiImpl() {
        modulesNodeByName = new HashMap<>();
        modelsTree = new HashMap<>();
    }

    @Override
    public FieldTreeImpl getModel(String modelName) {
        return Optional.ofNullable(modelsTree.get(modelName))
                .orElseThrow(() -> new IllegalArgumentException("Module not found " + modelName));
    }

    @Override
    public Set<String> getAllModelName() {
        return modelsTree.keySet();
    }

    @Override
    public Set<FieldTree> getAllModel() {
        return allModelTree;
    }

    public void addModule(String moduleName, ModelOfModuleInfo moduleInfo) {
        modulesNodeByName.put(moduleName, moduleInfo);
    }

    public void calculateTreeModel(ModuleTree moduleTree) {
        ModuleTreeNode base = moduleTree.getBase();
        Map<String, FieldTreeImpl> modelsTree = new HashMap<>();
        recursiveCalculateTree(base, modelsTree);
        allModelTree = Collections.unmodifiableSet(new HashSet<>(modelsTree.values()));
    }

    private void recursiveCalculateTree(ModuleTreeNode node, Map<String, FieldTreeImpl> modelsTree) {
        if (node == null){
            return;
        }
        for (MetaInfoModel model : modulesNodeByName.get(node.info().techincalName()).getModel().values()) {
            FieldTreeImpl modelTree = modelsTree.getOrDefault(model.getName(), new FieldTreeImpl(model.getName()));
            model.bigStringField().forEach(f -> modelTree.addBigStringField(f.getName(), new FieldNodeImpl<>(f)));
            model.binaryField().forEach(f -> modelTree.addBinaryField(f.getName(), new FieldNodeImpl<>(f)));
            model.booleanField().forEach(f -> modelTree.addBooleanField(f.getName(), new FieldNodeImpl<>(f)));
            model.dateField().forEach(f -> modelTree.addDateField(f.getName(), new FieldNodeImpl<>(f)));
            model.dateTimeField().forEach(f -> modelTree.addDateTimeField(f.getName(), new FieldNodeImpl<>(f)));
            model.decimalField().forEach(f -> modelTree.addDecimalField(f.getName(), new FieldNodeImpl<>(f)));
            model.floatField().forEach(f -> modelTree.addFloatField(f.getName(), new FieldNodeImpl<>(f)));
            model.intField().forEach(f -> modelTree.addIntField(f.getName(), new FieldNodeImpl<>(f)));
            model.longField().forEach(f -> modelTree.addLongField(f.getName(), new FieldNodeImpl<>(f)));
            model.stringField().forEach(f -> modelTree.addStringField(f.getName(), new FieldNodeImpl<>(f)));
            model.timeField().forEach(f -> modelTree.addTimeField(f.getName(), new FieldNodeImpl<>(f)));

            model.mtmField().forEach(f -> modelTree.addMtmField(f.getName(), new FieldNodeImpl<>(f)));
            model.mtoField().forEach(f -> modelTree.addMtoField(f.getName(), new FieldNodeImpl<>(f)));
            model.otmField().forEach(f -> modelTree.addOtmField(f.getName(), new FieldNodeImpl<>(f)));
            model.otoField().forEach(f -> modelTree.addOtoField(f.getName(), new FieldNodeImpl<>(f)));

            modelsTree.put(model.getName(), modelTree);
        }
        for (ModuleTreeNode parent : node.getParent()) {
            recursiveCalculateTree(parent, modelsTree);
        }
    }
}
