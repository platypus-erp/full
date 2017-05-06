package org.platypus.builder.core;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModelTree;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.records.quick.AstRecordRegistry;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public interface ModuleLoader {

    PlatypusCompleteModuleInfo getCurrentModule();

    ModuleTree getModuleTree();

    ModelTree getModelTree();

    ModelsMerged getModelsMerged();

    AstRecordRegistry getRecordRegistry();
}
