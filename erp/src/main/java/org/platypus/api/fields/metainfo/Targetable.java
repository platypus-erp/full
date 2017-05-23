package org.platypus.api.fields.metainfo;

import org.platypus.api.BaseModel;
import org.platypus.api.annotations.model.PlatypusModel;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/04/17.
 */
@FunctionalInterface
public interface Targetable {

    Class<? extends BaseModel> target();

    default String targetName(){
        return target().getAnnotation(PlatypusModel.class).value();
    }

    default String targetPkg(){
        return target().getPackage().getName();
    }
}
