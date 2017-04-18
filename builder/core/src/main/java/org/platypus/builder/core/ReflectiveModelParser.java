package org.platypus.builder.core;


import org.platypus.api.BaseModel;
import org.platypus.api.annotations.field.BigStringFieldDefinition;
import org.platypus.api.annotations.field.BinaryFieldDefinition;
import org.platypus.api.annotations.field.BooleanFieldDefinition;
import org.platypus.api.annotations.field.ComputedFieldDefinition;
import org.platypus.api.annotations.field.DateFieldDefinition;
import org.platypus.api.annotations.field.DateTimeFieldDefinition;
import org.platypus.api.annotations.field.DecimalFieldDefinition;
import org.platypus.api.annotations.field.FloatFieldDefinition;
import org.platypus.api.annotations.field.LongFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.field.TimeFieldDefinition;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.metainfo.MetaInfoModel;
import org.platypus.builder.core.internal.MetaInfoModelImpl;
import org.platypus.builder.core.internal.literral.BasicFieldDef;
import org.platypus.builder.core.internal.literral.BigStringFieldLiteral;
import org.platypus.builder.core.internal.literral.BinaryFieldLiteral;
import org.platypus.builder.core.internal.literral.BooleanFieldLiteral;
import org.platypus.builder.core.internal.literral.DateFieldLiteral;
import org.platypus.builder.core.internal.literral.DateTimeFieldLiteral;
import org.platypus.builder.core.internal.literral.DecimalFieldLiteral;
import org.platypus.builder.core.internal.literral.FloatFieldLiteral;
import org.platypus.builder.core.internal.literral.LongFieldLitteral;
import org.platypus.builder.core.internal.literral.StringFieldLiteral;
import org.platypus.builder.core.internal.literral.TimeFieldLiteral;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * @author chmuchme
 * @since 0.1
 * on 13/04/17.
 */
public class ReflectiveModelParser implements BaseModel {

    public MetaInfoModel parse(BaseModel model) {
        if (!model.getClass().isAnnotationPresent(PlatypusModel.class)) {
            throw new IllegalArgumentException(String.format("The class[%s] should be annotated with %s",
                    model.getClass().getCanonicalName(),
                    PlatypusModel.class.getCanonicalName()));
        }
        Class<?> baseModelClass = model.getClass();
        MetaInfoModelImpl impl;
        PlatypusModel annoModel = baseModelClass.getAnnotation(PlatypusModel.class);
        if (annoModel.inherit().length == 0) {
            impl = new MetaInfoModelImpl(baseModelClass.getSimpleName(), annoModel.value());
        } else if (annoModel.value().isEmpty()) {
            impl = new MetaInfoModelImpl(baseModelClass.getSimpleName(), Arrays.stream(annoModel.inherit())
                    .map(i -> i.getAnnotation(PlatypusModel.class).value())
                    .toArray(String[]::new));
        } else if (!annoModel.value().isEmpty()){
            impl = new MetaInfoModelImpl(baseModelClass.getSimpleName(), annoModel.value(),
                    Arrays.stream(annoModel.inherit())
                            .map(i -> i.getAnnotation(PlatypusModel.class).value())
                            .toArray(String[]::new));
        } else {
            throw new IllegalArgumentException(String.format("The class[%s] should be annotated with %s " +
                            "and PlatypusModel.value or PlatypusModel.inherits should be filled",
                    this.getClass().getCanonicalName(),
                    PlatypusModel.class.getCanonicalName()));
        }
        return reflectiveConstructMetaInfo(impl, baseModelClass.getDeclaredFields());
    }

    private MetaInfoModel reflectiveConstructMetaInfo(MetaInfoModelImpl impl, Field[] fields) {
        for (Field f : fields) {
            create(f, BigStringFieldDefinition.class, BigStringFieldLiteral::new).ifPresent(impl::add);
            create(f, BinaryFieldDefinition.class, BinaryFieldLiteral::new).ifPresent(impl::add);
            create(f, BooleanFieldDefinition.class, BooleanFieldLiteral::new).ifPresent(impl::add);
            create(f, DateFieldDefinition.class, DateFieldLiteral::new).ifPresent(impl::add);
            create(f, DateTimeFieldDefinition.class, DateTimeFieldLiteral::new).ifPresent(impl::add);
            create(f, DecimalFieldDefinition.class, DecimalFieldLiteral::new).ifPresent(impl::add);
            create(f, FloatFieldDefinition.class, FloatFieldLiteral::new).ifPresent(impl::add);
            create(f, LongFieldDefinition.class, LongFieldLitteral::new).ifPresent(impl::add);
            create(f, StringFieldDefinition.class, StringFieldLiteral::new).ifPresent(impl::add);
            create(f, TimeFieldDefinition.class, TimeFieldLiteral::new).ifPresent(impl::add);
        }
        return impl;
    }

    private <T extends BasicFieldDef, A extends Annotation> Optional<T> create(
            Field field, Class<A> annotation, BiFunction<String, A, T> constructor) {

        if (field.isAnnotationPresent(annotation)) {
            if (field.isAnnotationPresent(ComputedFieldDefinition.class)
                    && field.isAnnotationPresent(RelatedFieldDefinition.class)) {
                throw new IllegalArgumentException(
                        String.format("The field[%s] can't be computed and related in the same time", field.getName()));
            }
            T t = constructor.apply(field.getName(), field.getAnnotation(annotation));
            if (field.isAnnotationPresent(ComputedFieldDefinition.class)) {
                t.fillComputed(field.getAnnotation(ComputedFieldDefinition.class));
            }
            if (field.isAnnotationPresent(RelatedFieldDefinition.class)) {
                t.fillRelated(field.getAnnotation(RelatedFieldDefinition.class));
            }
            return Optional.of(t);
        }
        return Optional.empty();
    }
}
