package org.platypus.builder.core;

import org.platypus.api.module.PlatypusCompleteModuleInfo;
import org.platypus.builder.core.model.merger.ModelsMerged;
import org.platypus.builder.core.model.tree.ModuleTreeModel;
import org.platypus.builder.core.moduletree.ModuleTree;
import org.platypus.builder.core.records.complete.RecordRegistry;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public interface ModuleLoader {

    PlatypusCompleteModuleInfo getCurrentModule();

    ModuleTree getModuleTree();

    ModuleTreeModel getModelTree();

    ModelsMerged getModelsMerged();

    RecordRegistry getRecordRegistry();
}
