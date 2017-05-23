package org.platypus.plugin.generator.jpa.internal;


import com.squareup.javapoet.ArrayTypeName;
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
import org.platypus.api.fields.impl.BigStringFieldImpl;
import org.platypus.api.fields.impl.BinaryFieldImpl;
import org.platypus.api.fields.impl.BooleanFieldImpl;
import org.platypus.api.fields.impl.DateFieldImpl;
import org.platypus.api.fields.impl.DateTimeFieldImpl;
import org.platypus.api.fields.impl.DecimalFieldImpl;
import org.platypus.api.fields.impl.FloatFieldImpl;
import org.platypus.api.fields.impl.IntFieldImpl;
import org.platypus.api.fields.impl.LongFieldImpl;
import org.platypus.api.fields.impl.StringFieldImpl;
import org.platypus.api.fields.impl.TimeFieldImpl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class JpaUtils {
    private static final Map<String, TypeName> JAVA_TYPE = new HashMap<>(11);
    static {
        JAVA_TYPE.put(BigStringFieldDefinition.class.getCanonicalName(), ClassName.get(String.class));
        JAVA_TYPE.put(BinaryFieldDefinition.class.getCanonicalName(), ArrayTypeName.of(TypeName.BYTE));
        JAVA_TYPE.put(BooleanFieldDefinition.class.getCanonicalName(), TypeName.BOOLEAN);
        JAVA_TYPE.put(DateFieldDefinition.class.getCanonicalName(), ClassName.get(LocalDate.class));
        JAVA_TYPE.put(DateTimeFieldDefinition.class.getCanonicalName(), ClassName.get(LocalDateTime.class));
        JAVA_TYPE.put(DecimalFieldDefinition.class.getCanonicalName(), ClassName.get(BigDecimal.class));
        JAVA_TYPE.put(FloatFieldDefinition.class.getCanonicalName(), TypeName.FLOAT);
        JAVA_TYPE.put(LongFieldDefinition.class.getCanonicalName(), TypeName.LONG);
        JAVA_TYPE.put(IntFieldDefinition.class.getCanonicalName(), TypeName.INT);
        JAVA_TYPE.put(StringFieldDefinition.class.getCanonicalName(), ClassName.get(String.class));
        JAVA_TYPE.put(TimeFieldDefinition.class.getCanonicalName(), ClassName.get(LocalTime.class));
    }

    public static TypeName getJavaType(Annotation fieldType){
        return JAVA_TYPE.get(fieldType.annotationType().getCanonicalName());
    }

    private static final Map<String, TypeName> RECORD_FIELD_TYPE = new HashMap<>(11);
    static {
        RECORD_FIELD_TYPE.put(BigStringFieldDefinition.class.getCanonicalName(), ClassName.get(BigStringField.class));
        RECORD_FIELD_TYPE.put(BinaryFieldDefinition.class.getCanonicalName(), ClassName.get(BinaryField.class));
        RECORD_FIELD_TYPE.put(BooleanFieldDefinition.class.getCanonicalName(), ClassName.get(BooleanField.class));
        RECORD_FIELD_TYPE.put(DateFieldDefinition.class.getCanonicalName(), ClassName.get(DateField.class));
        RECORD_FIELD_TYPE.put(DateTimeFieldDefinition.class.getCanonicalName(), ClassName.get(DateTimeField.class));
        RECORD_FIELD_TYPE.put(DecimalFieldDefinition.class.getCanonicalName(), ClassName.get(DecimalField.class));
        RECORD_FIELD_TYPE.put(FloatFieldDefinition.class.getCanonicalName(), ClassName.get(FloatField.class));
        RECORD_FIELD_TYPE.put(IntFieldDefinition.class.getCanonicalName(), ClassName.get(IntField.class));
        RECORD_FIELD_TYPE.put(LongFieldDefinition.class.getCanonicalName(), ClassName.get(LongField.class));
        RECORD_FIELD_TYPE.put(StringFieldDefinition.class.getCanonicalName(), ClassName.get(StringField.class));
        RECORD_FIELD_TYPE.put(TimeFieldDefinition.class.getCanonicalName(), ClassName.get(TimeField.class));
    }

    private static final Map<String, TypeName> RECORD_FIELD_TYPE_IMPL = new HashMap<>(11);
    static {
        RECORD_FIELD_TYPE_IMPL.put(BigStringFieldDefinition.class.getCanonicalName(), ClassName.get(BigStringFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(BinaryFieldDefinition.class.getCanonicalName(), ClassName.get(BinaryFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(BooleanFieldDefinition.class.getCanonicalName(), ClassName.get(BooleanFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(DateFieldDefinition.class.getCanonicalName(), ClassName.get(DateFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(DateTimeFieldDefinition.class.getCanonicalName(), ClassName.get(DateTimeFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(DecimalFieldDefinition.class.getCanonicalName(), ClassName.get(DecimalFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(FloatFieldDefinition.class.getCanonicalName(), ClassName.get(FloatFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(IntFieldDefinition.class.getCanonicalName(), ClassName.get(IntFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(LongFieldDefinition.class.getCanonicalName(), ClassName.get(LongFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(StringFieldDefinition.class.getCanonicalName(), ClassName.get(StringFieldImpl.class));
        RECORD_FIELD_TYPE_IMPL.put(TimeFieldDefinition.class.getCanonicalName(), ClassName.get(TimeFieldImpl.class));
    }

    public static TypeName getRecordFieldInterface(Annotation fieldType){
        return RECORD_FIELD_TYPE.get(fieldType.annotationType().getCanonicalName());
    }

    public static TypeName getRecordFieldImpl(Annotation fieldType){
        return RECORD_FIELD_TYPE_IMPL.get(fieldType.annotationType().getCanonicalName());
    }
}
