package org.platypus.builder.core.field.tree;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface FieldTreeApi {

    FieldTree getModel(String modelName);
    Set<String> getAllModelName();
    Set<FieldTree> getAllModel();
}
