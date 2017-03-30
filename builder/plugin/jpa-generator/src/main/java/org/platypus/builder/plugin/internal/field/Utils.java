package org.platypus.builder.plugin.internal.field;


import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
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
        JAVA_TYPE.put(MetaInfoBigStringField.class.getCanonicalName(), ClassName.get(String.class));
        JAVA_TYPE.put(MetaInfoBinaryField.class.getCanonicalName(), ArrayTypeName.of(TypeName.BYTE));
        JAVA_TYPE.put(MetaInfoBooleanField.class.getCanonicalName(), TypeName.BOOLEAN);
        JAVA_TYPE.put(MetaInfoDateField.class.getCanonicalName(), ClassName.get(LocalDate.class));
        JAVA_TYPE.put(MetaInfoDateTimeField.class.getCanonicalName(), ClassName.get(LocalDateTime.class));
        JAVA_TYPE.put(MetaInfoDecimalField.class.getCanonicalName(), ClassName.get(BigDecimal.class));
        JAVA_TYPE.put(MetaInfoFloatField.class.getCanonicalName(), TypeName.FLOAT);
        JAVA_TYPE.put(MetaInfoLongField.class.getCanonicalName(), TypeName.LONG);
        JAVA_TYPE.put(MetaInfoIntField.class.getCanonicalName(), TypeName.INT);
        JAVA_TYPE.put(MetaInfoStringField.class.getCanonicalName(), ClassName.get(String.class));
        JAVA_TYPE.put(MetaInfoTimeField.class.getCanonicalName(), ClassName.get(LocalTime.class));
    }

    static TypeName getJavaType(Object fieldType){
        return JAVA_TYPE.get(fieldType.getClass().getCanonicalName());
    }
}
