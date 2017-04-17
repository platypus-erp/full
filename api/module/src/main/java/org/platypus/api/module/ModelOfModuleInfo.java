package org.platypus.api.module;

import org.platypus.api.fields.metainfo.MetaInfoModel;

import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public interface ModelOfModuleInfo {

    Map<String, MetaInfoModel> getModel();
}
