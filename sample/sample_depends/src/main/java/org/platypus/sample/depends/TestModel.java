package org.platypus.sample.depends;

import org.platypus.api.BaseModel;
import org.platypus.builder.core.ReflectiveModelParser;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.Field;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
@PlatypusModel("test")
public class TestModel implements BaseModel{

    @StringFieldDefinition
    Field name;
}
