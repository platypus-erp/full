package org.platypus.api.fields.metainfo;


import org.platypus.api.Namable;
import org.platypus.api.annotations.field.ManyToOneFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.model.PlatypusModel;

import javax.persistence.ManyToOne;
import java.lang.annotation.Annotation;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface MetaInfoManyToOneField extends ManyToOneFieldDefinition, Namable {

    default String targetName() {
        return target().getAnnotation(PlatypusModel.class).value();
    }

    default String targetPkg() {
        return target().getPackage().getName();
    }

}