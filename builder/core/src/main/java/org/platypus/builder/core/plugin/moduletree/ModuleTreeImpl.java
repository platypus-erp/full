package org.platypus.builder.core.plugin.moduletree;

import org.platypus.api.module.PlatypusCompleteModuleInfo;

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
public class ModuleTreeImpl implements ModuleTree {
    final Map<String, ModuleTreeNodeImpl> modulesNodeByName = new HashMap<>();
    private Set<ModuleTreeNode> moduleTreeNodes;
    private ModuleTreeNodeImpl base;

    @Override
    public ModuleTreeNode getBase() {
        return base;
    }

    @Override
    public ModuleTreeNode getModule(String moduleName) {
        return Optional.ofNullable(modulesNodeByName.get(moduleName))
                .orElseThrow(() -> new IllegalArgumentException("Module not found " + moduleName));
    }

    @Override
    public Set<String> getAllModuleName() {
        return modulesNodeByName.keySet();
    }

    @Override
    public Set<ModuleTreeNode> getAllModule() {
        return moduleTreeNodes;
    }

    void addModule(PlatypusCompleteModuleInfo moduleInfo) {
        modulesNodeByName.put(moduleInfo.techincalName(), new ModuleTreeNodeImpl(moduleInfo));
    }


    void calculateTree() {
        for (ModuleTreeNodeImpl module : modulesNodeByName.values()) {
            PlatypusCompleteModuleInfo info = module.info();
            if ("base".equals(info.techincalName())) {
                base = module;
            }
            for (String depend : info.depends()) {
                modulesNodeByName.get(depend).addParent(module);
            }
        }
        moduleTreeNodes = Collections.unmodifiableSet(new HashSet<>(modulesNodeByName.values()));
    }
}
