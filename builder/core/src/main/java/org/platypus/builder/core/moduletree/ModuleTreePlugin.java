package org.platypus.builder.core.moduletree;


import org.platypus.api.module.PlatypusCompleteModuleInfo;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModuleTreePlugin {

    private ModuleTreeImpl tree = new ModuleTreeImpl();

    public String name() {
        return "module-registry";
    }

    public void addModule(PlatypusCompleteModuleInfo moduleInfo) {
        System.out.println("Load of module " + moduleInfo.getName());
        tree.addModule(moduleInfo);
    }

    public ModuleTreeImpl build() {
        tree.calculateTree();
        return tree;
    }

    public ModuleTreeImpl getTree(){
        return tree;
    }
}
