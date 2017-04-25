package org.platypus.builder.core.model.tree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface ModuleTreeModel {

    ModelTree getBase();
    ModelTree getModel(String modelName);
    Set<String> getAllModelName();
    Set<ModelTree> getAllModel();
}
