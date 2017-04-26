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
import org.platypus.api.annotations.field.ManyToManyFieldDefinition;
import org.platypus.api.annotations.field.ManyToOneFieldDefinition;
import org.platypus.api.annotations.field.OneToManyFieldDefinition;
import org.platypus.api.annotations.field.OneToOneFieldDefinition;
import org.platypus.api.annotations.field.RelatedFieldDefinition;
import org.platypus.api.annotations.field.StringFieldDefinition;
import org.platypus.api.annotations.field.TimeFieldDefinition;
import org.platypus.api.annotations.model.PlatypusInherit;
import org.platypus.api.annotations.model.PlatypusInheritMulti;
import org.platypus.api.annotations.model.PlatypusModel;
import org.platypus.api.fields.NewField;
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
import org.platypus.builder.core.internal.literral.ManyToManyFieldLiteral;
import org.platypus.builder.core.internal.literral.ManyToOneFieldLiteral;
import org.platypus.builder.core.internal.literral.OneToManyFieldLiteral;
import org.platypus.builder.core.internal.literral.OneToOneFieldLiteral;
import org.platypus.builder.core.internal.literral.StringFieldLiteral;
import org.platypus.builder.core.internal.literral.TimeFieldLiteral;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
        //TODO replace with Java9 Optionnal#or
        Optional<MetaInfoModelImpl> impl = getAnnotation(baseModelClass, PlatypusModel.class)
                .map(a -> new MetaInfoModelImpl(baseModelClass.getSimpleName(), a));
//        impl = or(impl, getAnnotation(baseModelClass, PlatypusInherit.class)
//                .map(ai -> new MetaInfoModelImpl(baseModelClass.getSimpleName(), ai))
//        );
//        impl = or(impl, getAnnotation(baseModelClass, PlatypusInheritMulti.class)
//                .map(aim -> new MetaInfoModelImpl(baseModelClass.getSimpleName(), aim))
//        );
        return reflectiveConstructMetaInfo(
                impl.orElseThrow(IllegalAccessError::new),
                baseModelClass.getDeclaredFields());
    }

    private <T> Optional<T> or(Optional<T> v1, Optional<T> v2) {
        return v1.isPresent() ? v1 : v2;
    }

    private <T extends Annotation> Optional<T> getAnnotation(Class<?> aClass, Class<T> aAnnotation) {
        return Optional.ofNullable(aClass.getAnnotation(aAnnotation));
    }

    private MetaInfoModel reflectiveConstructMetaInfo(MetaInfoModelImpl impl, Field[] fields) {
        for (Field f : fields) {
            parseBasicField(f, BigStringFieldDefinition.class, BigStringFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, BinaryFieldDefinition.class, BinaryFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, BooleanFieldDefinition.class, BooleanFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, DateFieldDefinition.class, DateFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, DateTimeFieldDefinition.class, DateTimeFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, DecimalFieldDefinition.class, DecimalFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, FloatFieldDefinition.class, FloatFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, LongFieldDefinition.class, LongFieldLitteral::new).ifPresent(impl::add);
            parseBasicField(f, StringFieldDefinition.class, StringFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, TimeFieldDefinition.class, TimeFieldLiteral::new).ifPresent(impl::add);

            parseBasicField(f, OneToManyFieldDefinition.class, OneToManyFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, ManyToOneFieldDefinition.class, ManyToOneFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, ManyToManyFieldDefinition.class, ManyToManyFieldLiteral::new).ifPresent(impl::add);
            parseBasicField(f, OneToOneFieldDefinition.class, OneToOneFieldLiteral::new).ifPresent(impl::add);
        }
        return impl;
    }

    private <T extends BasicFieldDef, A extends Annotation> Optional<T> parseBasicField(
            Field field, Class<A> annotation, BiFunction<String, A, T> constructor) {

        if (field.isAnnotationPresent(annotation)) {
            if (field.isAnnotationPresent(ComputedFieldDefinition.class)
                    && field.isAnnotationPresent(RelatedFieldDefinition.class)) {
                throw new IllegalArgumentException(
                        String.format("The field[%s] can't be computed and related in the same time", field.getName()));
            }
            T t = constructor.apply(field.getName(), field.getAnnotation(annotation));
//            if (field.isAnnotationPresent(ComputedFieldDefinition.class)) {
//                t.fillComputed(field.getAnnotation(ComputedFieldDefinition.class));
//            }
//            if (field.isAnnotationPresent(RelatedFieldDefinition.class)) {
//                t.fillRelated(field.getAnnotation(RelatedFieldDefinition.class));
//            }
            t.setNewField(field.getType() == NewField.class);
            return Optional.of(t);
        }

        return Optional.empty();
    }
}
