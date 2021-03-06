package org.platypus.builder.core.internal.literral;


import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface BasicFieldDef extends FieldDef {

    void fillComputed(ComputedFieldDefinition computed);
    void fillRelated(RelatedFieldDefinition related);

    void setNewField(boolean b);

    boolean isNewField();
}
