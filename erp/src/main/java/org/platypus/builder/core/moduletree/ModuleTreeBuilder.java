package org.platypus.builder.core.moduletree;


import org.platypus.api.module.PlatypusCompleteModuleInfo;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModuleTreeBuilder {

    private ModuleTreeImpl tree = new ModuleTreeImpl();

    public String name() {
        return "ui-registry";
    }

    public static ModuleTreeImpl emptyTree(){
        return new ModuleTreeImpl();
    }

    public ModuleTreeImpl build(Set<PlatypusCompleteModuleInfo> depends) {
        depends.forEach(this::addModule);
        tree.calculateTree();
        return tree;
    }

    private void addModule(PlatypusCompleteModuleInfo moduleInfo) {
        System.out.println("Load of ui " + moduleInfo.getName());
        tree.addModule(moduleInfo);
    }

    public ModuleTreeImpl getTree(){
        return tree;
    }
}
