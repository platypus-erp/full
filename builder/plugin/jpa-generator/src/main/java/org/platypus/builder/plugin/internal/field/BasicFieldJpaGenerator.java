package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
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

import javax.lang.model.element.Modifier;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Optional;

import static org.platypus.builder.plugin.internal.field.Utils.getJavaType;
import static org.platypus.builder.utils.Utils.TO_SQL;
import static org.platypus.builder.utils.ValuesUtils.isFalseOrDefault;
import static org.platypus.builder.utils.ValuesUtils.isTrueOrDefault;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BasicFieldJpaGenerator {


    public static final String NULLABLE = "nullable";
    public static final String INSERTABLE = "insertable";
    public static final String UPDATABLE = "updatable";
    public static final String NAME = "name";
    public static final String $_T_$_L = "$T.$L";
    public static final String $_S = "$S";
    public static final String LITTERAL = "$L";

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoBigStringField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Lob.class).build());
        f.addAnnotation(AnnotationSpec.builder(Basic.class)
                .addMember("fetch", $_T_$_L,
                        ClassName.get(FetchType.class),
                        isTrueOrDefault(field.lazy()) ? FetchType.EAGER : FetchType.LAZY).build());
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoBinaryField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Lob.class).build());
        f.addAnnotation(AnnotationSpec.builder(Basic.class)
                .addMember("fetch", $_T_$_L,
                        ClassName.get(FetchType.class),
                        isTrueOrDefault(field.lazy()) ? FetchType.EAGER : FetchType.LAZY).build());
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoBooleanField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, false)
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDateField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDateTimeField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDecimalField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        if (!MetaInfoDecimalField.DEFAULT.equals(field.defaultValue())){
            f.initializer($_T_$_L, ClassName.get(BigDecimal.class), "ZERO");
        } else {
            f.initializer("new $T($S)", ClassName.get(BigDecimal.class), field.defaultValue());
        }

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoFloatField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        if (Float.MIN_VALUE == field.defaultValue()){
            f.initializer("$LF", 0);
        } else {
            f.initializer("$LF", field.defaultValue());
        }

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoIntField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        if (Integer.MIN_VALUE == field.defaultValue()){
            f.initializer(LITTERAL, 0);
        } else {
            f.initializer(LITTERAL, field.defaultValue());
        }
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoLongField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        if (Integer.MIN_VALUE == field.defaultValue()){
            f.initializer(LITTERAL, 0);
        } else {
            f.initializer(LITTERAL, field.defaultValue());
        }
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoStringField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);


        AnnotationSpec.Builder size = AnnotationSpec.builder(Size.class);
        if (field.maxSize() != Integer.MAX_VALUE) {
            size.addMember("max", LITTERAL, field.maxSize());
        }
        if (field.minSize() != Integer.MIN_VALUE) {
            size.addMember("min", LITTERAL, field.minSize());
        }
        if (field.minSize() != Integer.MIN_VALUE || field.maxSize() != Integer.MAX_VALUE) {
            f.addAnnotation(size.build());
        }
        switch (field.required()) {
            case NOT_BLANK:
//                f.addAnnotation(ClassName.get(NotBlank.class));
                break;
            case NOT_NULL:
                f.addAnnotation(ClassName.get(NotNull.class));
                break;
            case NONE:
                //Nothing to do
                break;
            default:
                throw new IllegalArgumentException("StringFieldDefinition#required not found " + field.required());

        }
        if (!MetaInfoStringField.DEFAULT.equals(field.match())) {
            AnnotationSpec.Builder pattern = AnnotationSpec.builder(Pattern.class);
            pattern.addMember("regexp", $_S, field.match());
            f.addAnnotation(pattern.build());
        }

        AnnotationSpec.Builder column = AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()));
        f.addAnnotation(column.build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoTimeField field) {
        FieldSpec.Builder f = FieldSpec.builder(getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

}
