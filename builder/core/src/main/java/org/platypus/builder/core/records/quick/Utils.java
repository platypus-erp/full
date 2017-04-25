package org.platypus.builder.core.records.quick;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import org.platypus.api.annotations.field.BigStringFieldDefinition;
import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.annotations.field.DateFieldDefinition;
import org.platypus.api.annotations.field.DateTimeFieldDefinition;
import org.platypus.api.annotations.field.DecimalFieldDefinition;
import org.platypus.api.annotations.field.FloatFieldDefinition;
import org.platypus.api.annotations.field.IntFieldDefinition;
import org.platypus.api.annotations.field.LongFieldDefinition;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.field.TimeFieldDefinition;
import org.platypus.api.fields.BigStringField;
import org.platypus.api.fields.BinaryField;
import org.platypus.api.fields.BooleanField;
import org.platypus.api.fields.DateField;
import org.platypus.api.fields.DateTimeField;
import org.platypus.api.fields.DecimalField;
import org.platypus.api.fields.FloatField;
import org.platypus.api.fields.IntField;
import org.platypus.api.fields.LongField;
import org.platypus.api.fields.StringField;
import org.platypus.api.fields.TimeField;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class Utils {

    private static final Map<String, ClassName> RECORD_FIELD_TYPE = new HashMap<>(11);
    static {
        RECORD_FIELD_TYPE.put(BigStringFieldDefinition.class.getSimpleName(), ClassName.get(BigStringField.class));
        RECORD_FIELD_TYPE.put(BinaryFieldDefinition.class.getSimpleName(), ClassName.get(BinaryField.class));
        RECORD_FIELD_TYPE.put(BooleanFieldDefinition.class.getSimpleName(), ClassName.get(BooleanField.class));
        RECORD_FIELD_TYPE.put(DateFieldDefinition.class.getSimpleName(), ClassName.get(DateField.class));
        RECORD_FIELD_TYPE.put(DateTimeFieldDefinition.class.getSimpleName(), ClassName.get(DateTimeField.class));
        RECORD_FIELD_TYPE.put(DecimalFieldDefinition.class.getSimpleName(), ClassName.get(DecimalField.class));
        RECORD_FIELD_TYPE.put(FloatFieldDefinition.class.getSimpleName(), ClassName.get(FloatField.class));
        RECORD_FIELD_TYPE.put(IntFieldDefinition.class.getSimpleName(), ClassName.get(IntField.class));
        RECORD_FIELD_TYPE.put(LongFieldDefinition.class.getSimpleName(), ClassName.get(LongField.class));
        RECORD_FIELD_TYPE.put(StringFieldDefinition.class.getSimpleName(), ClassName.get(StringField.class));
        RECORD_FIELD_TYPE.put(TimeFieldDefinition.class.getSimpleName(), ClassName.get(TimeField.class));
    }

    public static ClassName getInterfaceByName(String name){
        return RECORD_FIELD_TYPE.get(name);
    }
}
