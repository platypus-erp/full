package org.platypus.builder.core.service.manager.visitor;

import com.squareup.javapoet.ClassName;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 09/06/17.
 */
class MetaSeviceInfo {
    public final Map<String, String> imports;
    public final ClassName model;

    public MetaSeviceInfo(Map<String, String> imports, ClassName model) {
        this.imports = imports;
        this.model = model;
    }
}
