package org.platypus.builder.plugin.internal.field;


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
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

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
class Utils {
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

    static TypeName getJavaType(Annotation fieldType){
        return JAVA_TYPE.get(fieldType.annotationType().getCanonicalName());
    }
}
