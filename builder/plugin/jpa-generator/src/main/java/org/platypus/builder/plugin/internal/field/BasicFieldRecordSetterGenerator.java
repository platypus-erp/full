package org.platypus.builder.plugin.internal.field;

import com.squareup.javapoet.*;
import org.platypus.api.Bool;
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
import org.apache.commons.lang3.StringUtils;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.Utils;
import org.platypus.builder.plugin.internal.JpaUtils;

import javax.lang.model.element.Modifier;

import java.util.Optional;
import java.util.function.Function;

import static org.platypus.builder.plugin.internal.JpaModelGenerator.getImplHibernateName;

/**
 * @author chmuchme
 * @since 0.1
 * on 19/04/17.
 */
public class BasicFieldRecordSetterGenerator {
    public Optional<MethodSpec> generateSetter(MetaInfoBigStringField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBinaryField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoBooleanField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDateTimeField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoDecimalField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoFloatField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoIntField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoLongField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoStringField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generateSetter(MetaInfoTimeField field){
        if (field.readonly() == Bool.TRUE){
            return Optional.empty();
        }
        return getSetter(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }

    private Optional<MethodSpec> getSetter(String name, TypeName field){
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name+"Field", Modifier.FINAL).build())
                .addCode("this.set$N($N.get());\n", StringUtils.capitalize(name), name+"Field")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getSetterUnwrap(field.getName(), Utils.toRecord(record), JpaImplT);
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToOneField field,
                                   Function<String, MetaInfoRecord> getRecord) {
        MetaInfoRecord record = getRecord.apply(field.targetName());
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getSetterUnwrap(field.getName(), Utils.toRecord(record), JpaImplT);
    }
    public Optional<MethodSpec> generateSetter(MetaInfoOneToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        MetaInfoRecordCollection record = getRecord.apply(field.targetName());
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getSetterUnwrapAsList(field.getName(), Utils.toRecordCollection(record), JpaImplT);
    }
    public Optional<MethodSpec> generateSetter(MetaInfoManyToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        MetaInfoRecordCollection record = getRecord.apply(field.targetName());
        ClassName JpaImplT = ClassName.get("",getImplHibernateName(field.target().getSimpleName()));
        return getSetterUnwrapAsList(field.getName(), Utils.toRecordCollection(record), JpaImplT);
    }
    private Optional<MethodSpec> getSetterUnwrapAsList(String name, TypeName field, TypeName jpaImpl){
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name+"Field", Modifier.FINAL).build())
                .addCode("this.set$N($N.unWrapAsList($T.class));\n", StringUtils.capitalize(name), name+"Field", jpaImpl)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
    private Optional<MethodSpec> getSetterUnwrap(String name, TypeName field, TypeName jpaImpl){
        return Optional.of(MethodSpec.methodBuilder(name)
                .addParameter(ParameterSpec.builder(field, name+"Field", Modifier.FINAL).build())
                .addCode("this.set$N($N.unWrap($T.class));\n", StringUtils.capitalize(name), name+"Field", jpaImpl)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .build());
    }
}
