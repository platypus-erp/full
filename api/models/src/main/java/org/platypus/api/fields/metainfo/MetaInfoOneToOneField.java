package org.platypus.api.fields.metainfo;


import org.platypus.api.Namable;
import org.platypus.api.annotations.field.OneToManyFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.model.PlatypusModel;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface MetaInfoOneToOneField extends OneToOneFieldDefinition, Namable {

    default String targetName(){
        return target().getAnnotation(PlatypusModel.class).value();
    }

    default String targetPkg(){
        return target().getPackage().getName();
    }
}
