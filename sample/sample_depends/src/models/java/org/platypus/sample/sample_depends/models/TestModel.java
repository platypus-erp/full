package org.platypus.sample.sample_depends.models;

import org.platypus.api.BaseModel;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.InheritField;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
@PlatypusModel("test")
public class TestModel implements BaseModel{

    @StringFieldDefinition
    InheritField name;
}
