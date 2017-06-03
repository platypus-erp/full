package org.platypus.builder.plugin.generator.jpa.internal.recordImpl;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoBooleanField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoManyToManyField;
import org.platypus.api.fields.metainfo.MetaInfoManyToOneField;
import org.platypus.api.fields.metainfo.MetaInfoOneToManyField;
import org.platypus.api.fields.metainfo.MetaInfoOneToOneField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;
import org.platypus.api.module.MetaInfoRecord;
import org.platypus.api.module.MetaInfoRecordCollection;
import org.platypus.builder.core.Utils;
import org.platypus.builder.plugin.generator.jpa.internal.JpaUtils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public abstract class FieldGenerator {
    private final Predicate<MetaInfoField> predicateGenerate;

    public FieldGenerator(Predicate<MetaInfoField> predicateGenerate) {
        this.predicateGenerate = predicateGenerate;
    }

    public Optional<MethodSpec> generate(MetaInfoBigStringField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoBinaryField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoBooleanField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoDateField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoDateTimeField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoDecimalField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoFloatField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoIntField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoLongField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoStringField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoTimeField field){
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), JpaUtils.getRecordFieldInterface(field));
    }
    public Optional<MethodSpec> generate(MetaInfoManyToOneField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), Utils.toRecord(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generate(MetaInfoOneToOneField field,
                                               Function<String, MetaInfoRecord> getRecord) {
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), Utils.toRecord(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generate(MetaInfoOneToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), Utils.toRecordCollection(getRecord.apply(field.targetName())));
    }
    public Optional<MethodSpec> generate(MetaInfoManyToManyField field,
                                               Function<String, MetaInfoRecordCollection> getRecord) {
        if (predicateGenerate.test(field)){
            return Optional.empty();
        }
        return getMethod(field.getName(), Utils.toRecordCollection(getRecord.apply(field.targetName())));
    }

    protected abstract Optional<MethodSpec> getMethod(String name, TypeName field);
}
