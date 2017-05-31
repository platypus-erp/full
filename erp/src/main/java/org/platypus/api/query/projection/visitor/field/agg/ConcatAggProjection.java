package org.platypus.api.query.projection.visitor.field.agg;

import org.platypus.api.fields.StringField;
import org.platypus.api.query.projection.ProjectionVisitor;
import org.platypus.api.query.projection.visitor.field.AbstractFieldProjection;

/**
 * @author chmuchme
 * @since 0.1
 * on 27/05/17.
 */
public class ConcatAggProjection extends AbstractFieldProjection<ConcatAggProjection, StringField> {
    private final String separator;

    public ConcatAggProjection(StringField field, String separator) {
        super(field);
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

}
