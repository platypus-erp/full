package org.platypus.builder.core;


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
import org.platypus.api.annotations.field.ManyToManyFieldDefinition;
import org.platypus.api.annotations.field.ManyToOneFieldDefinition;
import org.platypus.api.annotations.field.OneToManyFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.field.PlatypusCascadeType;
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
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;

import javax.persistence.CascadeType;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class Utils {
    private static Pattern SQL_PATTERN = Pattern.compile("([a-z])([A-Z]+)");
    private static String SQL_REPLACEMENT = "$1_$2";
    public static Function<String,String> TO_SQL = str -> SQL_PATTERN.matcher(str).replaceAll(SQL_REPLACEMENT).toLowerCase();

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
    private static final Map<String, ClassName> RECORD_FIELD_TYPE_SIMPLE_NAME = new HashMap<>(15);
    static {
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(BigStringFieldDefinition.class.getSimpleName(), ClassName.get(BigStringField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(BinaryFieldDefinition.class.getSimpleName(), ClassName.get(BinaryField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(BooleanFieldDefinition.class.getSimpleName(), ClassName.get(BooleanField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(DateFieldDefinition.class.getSimpleName(), ClassName.get(DateField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(DateTimeFieldDefinition.class.getSimpleName(), ClassName.get(DateTimeField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(DecimalFieldDefinition.class.getSimpleName(), ClassName.get(DecimalField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(FloatFieldDefinition.class.getSimpleName(), ClassName.get(FloatField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(IntFieldDefinition.class.getSimpleName(), ClassName.get(IntField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(LongFieldDefinition.class.getSimpleName(), ClassName.get(LongField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(StringFieldDefinition.class.getSimpleName(), ClassName.get(StringField.class));
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(TimeFieldDefinition.class.getSimpleName(), ClassName.get(TimeField.class));

        RECORD_FIELD_TYPE_SIMPLE_NAME.put(OneToManyFieldDefinition.class.getSimpleName(), null);
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(ManyToManyFieldDefinition.class.getSimpleName(), null);
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(ManyToOneFieldDefinition.class.getSimpleName(), null);
        RECORD_FIELD_TYPE_SIMPLE_NAME.put(OneToOneFieldDefinition.class.getSimpleName(), null);
    }

    public static ClassName getInterfaceByName(String name){
        return RECORD_FIELD_TYPE_SIMPLE_NAME.get(name);
    }
    public static ClassName getInterfaceByName(String name, ClassName defaultValue){
        return RECORD_FIELD_TYPE_SIMPLE_NAME.getOrDefault(name, defaultValue);
    }
    public static boolean isSupportedInterfaceByName(String name){
        return RECORD_FIELD_TYPE_SIMPLE_NAME.containsKey(name);
    }

    static TypeName getRecordFieldInterface(Annotation fieldType){
        return RECORD_FIELD_TYPE.get(fieldType.annotationType().getCanonicalName());
    }

    static TypeName getRecordFieldImpl(Annotation fieldType){
        return RECORD_FIELD_TYPE_IMPL.get(fieldType.annotationType().getCanonicalName());
    }

    public static ClassName toRecordCollection(MetaInfoRecordCollection representation) {
        return ClassName.get(representation.getPkg(), representation.getClassName());
    }
    public static ClassName toRecordCollectionImpl(MetaInfoRecord representation) {
        return ClassName.get("", representation.getClassName() + "Impl");
    }

    public static ClassName toRecord(MetaInfoRecord representation) {
        return ClassName.get(representation.getPkg(), representation.getClassName());
    }
    public static ClassName toRecordImpl(MetaInfoRecord representation) {
        return ClassName.get("", representation.getClassName() + "Impl");
    }

    public static String toRecordName(String value) {
        return value;
    }
    public static String toRecordCollectionName(String value) {
        return value;
    }

    public static CascadeType[] toJpaCascadeType(PlatypusCascadeType[] platypusCascadeTypes, CascadeType... defaults) {
        if (platypusCascadeTypes.length < 0) {
            return defaults;
        } else {
            Arrays.sort(platypusCascadeTypes);
            if (Arrays.binarySearch(platypusCascadeTypes, PlatypusCascadeType.NONE) >= 0) {
                return new CascadeType[0];
            }
            if (Arrays.binarySearch(platypusCascadeTypes, PlatypusCascadeType.DEFAULT) >= 0) {
                return defaults;
            }
            return Arrays.stream(platypusCascadeTypes)
                    .map(p -> CascadeType.valueOf(p.toString()))
                    .toArray(CascadeType[]::new);
        }
    }
}
