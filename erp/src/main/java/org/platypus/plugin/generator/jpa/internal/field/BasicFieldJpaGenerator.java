package org.platypus.plugin.generator.jpa.internal.field;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.annotations.field.PlatypusCascadeType;
import org.platypus.api.fields.Bool;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.builder.core.Utils;
import org.platypus.builder.utils.ValuesUtils;
import org.platypus.builder.utils.javapoet.utils.JavaPoetTypeUtils;
import org.platypus.plugin.generator.jpa.internal.JpaModelGenerator;
import org.platypus.plugin.generator.jpa.internal.JpaUtils;

import javax.lang.model.element.Modifier;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.StringJoiner;

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
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Lob.class).build());
        f.addAnnotation(AnnotationSpec.builder(Basic.class)
                .addMember("fetch", $_T_$_L,
                        ClassName.get(FetchType.class),
                        ValuesUtils.isTrueOrDefault(field.lazy()) ? FetchType.EAGER : FetchType.LAZY).build());
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoBinaryField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Lob.class).build());
        f.addAnnotation(AnnotationSpec.builder(Basic.class)
                .addMember("fetch", $_T_$_L,
                        ClassName.get(FetchType.class),
                        ValuesUtils.isTrueOrDefault(field.lazy()) ? FetchType.EAGER : FetchType.LAZY).build());
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoBooleanField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, false)
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDateField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDateTimeField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoDecimalField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        if (!MetaInfoDecimalField.DEFAULT.equals(field.defaultValue())) {
            f.initializer($_T_$_L, ClassName.get(BigDecimal.class), "ZERO");
        } else {
            f.initializer("new $T($S)", ClassName.get(BigDecimal.class), field.defaultValue());
        }

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoFloatField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        if (Float.MIN_VALUE == field.defaultValue()) {
            f.initializer("$LF", 0);
        } else {
            f.initializer("$LF", field.defaultValue());
        }

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoIntField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        if (Integer.MIN_VALUE == field.defaultValue()) {
            f.initializer(LITTERAL, 0);
        } else {
            f.initializer(LITTERAL, field.defaultValue());
        }
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoLongField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        if (Long.MIN_VALUE == field.defaultValue()) {
            f.initializer(LITTERAL, 0);
        } else {
            f.initializer(LITTERAL, field.defaultValue());
        }
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoStringField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
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
//                f.addAnnotation(ClassName.newRecord(NotBlank.class));
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
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()));
        f.addAnnotation(column.build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoTimeField field) {
        FieldSpec.Builder f = FieldSpec.builder(JpaUtils.getJavaType(field), field.getName(), Modifier.PRIVATE);
        f.addAnnotation(AnnotationSpec.builder(Column.class)
                .addMember(NAME, $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember(NULLABLE, LITTERAL, ValuesUtils.isFalseOrDefault(field.required()))
                .addMember(INSERTABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.insertable()))
                .addMember(UPDATABLE, LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());

        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoManyToOneField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        FieldSpec.Builder f = FieldSpec.builder(JpaImplT, field.getName(), Modifier.PRIVATE);
        AnnotationSpec.Builder manyToOne = AnnotationSpec.builder(ManyToOne.class);
        if (Bool.TRUE == field.required()) {
            manyToOne.addMember("optional", LITTERAL, false);
        }
        addCascadeExpression(field.cascade(), manyToOne);
        f.addAnnotation(manyToOne.build());
        f.addAnnotation(AnnotationSpec.builder(JoinColumn.class)
                .addMember("name", $_S, "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember("updatable", LITTERAL, ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoOneToOneField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        FieldSpec.Builder f = FieldSpec.builder(JpaImplT, field.getName(), Modifier.PRIVATE);
        AnnotationSpec.Builder oneToOne = AnnotationSpec.builder(OneToOne.class);
        if (Bool.TRUE == field.required()) {
            oneToOne.addMember("optional", "$L", false);
        }
        if (StringUtils.isNotBlank(field.mappedBy())) {
            oneToOne.addMember("mappedBy", "$S", field.mappedBy());
        }
        addCascadeExpression(field.cascade(), oneToOne);
        f.addAnnotation(oneToOne.build());
        f.addAnnotation(AnnotationSpec.builder(JoinColumn.class)
                .addMember("name", "$S", "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember("updatable", "$L", ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoOneToManyField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        FieldSpec.Builder f = FieldSpec.builder(JavaPoetTypeUtils.ListType(JpaImplT), field.getName(), Modifier.PRIVATE);
        AnnotationSpec.Builder oneToMany = AnnotationSpec.builder(OneToMany.class);
        if (Bool.TRUE == field.required()) {
            oneToMany.addMember("optional", "$L", false);
        }
        if (StringUtils.isNotBlank(field.mappedBy())) {
            oneToMany.addMember("mappedBy", "$S", field.mappedBy());
        }
        addCascadeExpression(field.cascade(), oneToMany);
        f.addAnnotation(oneToMany.build());
        f.addAnnotation(AnnotationSpec.builder(JoinColumn.class)
                .addMember("name", "$S", "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember("updatable", "$L", ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    public Optional<FieldSpec> generatedFieldImpl(MetaInfoManyToManyField field) {
        ClassName JpaImplT = ClassName.get("", JpaModelGenerator.getImplHibernateName(field.target().getSimpleName()));
        FieldSpec.Builder f = FieldSpec.builder(JavaPoetTypeUtils.ListType(JpaImplT), field.getName(), Modifier.PRIVATE);
        AnnotationSpec.Builder manyToMany = AnnotationSpec.builder(ManyToMany.class);
        if (Bool.TRUE == field.required()) {
            manyToMany.addMember("optional", "$L", false);
        }
        addCascadeExpression(field.cascade(), manyToMany);
        f.addAnnotation(manyToMany.build());
        AnnotationSpec.Builder joinTable = AnnotationSpec.builder(JoinTable.class);
        f.addAnnotation(joinTable.build());


        f.addAnnotation(AnnotationSpec.builder(JoinColumn.class)
                .addMember("name", "$S", "\"" + Utils.TO_SQL.apply(field.getName()) + "\"")
                .addMember("updatable", "$L", ValuesUtils.isTrueOrDefault(field.updatable()))
                .build());
        return Optional.of(f.build());
    }

    private Optional<String> getCascadeExpression(PlatypusCascadeType[] cascade) {
        if (cascade.length > 0) {
            Object[] v = Utils.toJpaCascadeType(cascade);
            if (v.length > 0) {
                StringJoiner joinerCascade = new StringJoiner(", ", "{", "}");
                for (PlatypusCascadeType cascadeType : cascade) {
                    joinerCascade.add("$L");
                }
                return Optional.of(joinerCascade.toString());
            }
        }
        return Optional.empty();
    }

    private void addCascadeExpression(PlatypusCascadeType[] cascade, AnnotationSpec.Builder builder) {
        getCascadeExpression(cascade).ifPresent(s -> builder.addMember(
                "cascade",
                s,
                (Object[]) Utils.toJpaCascadeType(cascade))
        );
    }

}
