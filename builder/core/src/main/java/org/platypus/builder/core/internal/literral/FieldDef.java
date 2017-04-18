package org.platypus.builder.core.internal.literral;

import org.platypus.api.Namable;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface FieldDef extends
        RelatedFieldDefinition,
        ComputedFieldDefinition,
        Namable {
}
