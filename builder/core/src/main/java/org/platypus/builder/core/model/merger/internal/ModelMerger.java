package org.platypus.builder.core.model.merger.internal;

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
import org.platypus.builder.core.model.merger.ModelMerged;
import org.platypus.builder.core.model.merger.internal.field.BigStringFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.BinaryFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.BooleanFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.DateFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.DateTimeFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.DecimalFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.FieldMerger;
import org.platypus.builder.core.model.merger.internal.field.FloatFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.IntFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.LongFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.MtmFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.MtoFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.OtmFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.OtoFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.StringFieldLiteralMerger;
import org.platypus.builder.core.model.merger.internal.field.TimeFieldLiteralMerger;
import org.platypus.builder.core.model.tree.FieldNode;
import org.platypus.builder.core.model.tree.ModelTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelMerger {

    private String name;
    private Set<MultiColumnUniqueKey> multiColumnUniqueKeys;

    private Map<String, FieldMerger<MetaInfoBigStringField>> bigStringField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoBinaryField>> binaryField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoBooleanField>> booleanField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoDateField>> dateField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoDateTimeField>> dateTimeField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoDecimalField>> decimalField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoFloatField>> floatField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoIntField>> intField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoLongField>> longField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoStringField>> stringField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoTimeField>> timeField = new HashMap<>();

    private Map<String, FieldMerger<MetaInfoOneToOneField>> otoField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoOneToManyField>> otmField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoManyToOneField>> mtoField = new HashMap<>();
    private Map<String, FieldMerger<MetaInfoManyToManyField>> mtmField = new HashMap<>();

    public String getName() {
        return name;
    }

    public Set<MultiColumnUniqueKey> getMultiColumnUniqueKeys() {
        return multiColumnUniqueKeys;
    }

    public ModelMerger(ModelTree modelTree) {
        merge(modelTree);
    }

    public static ModelMerger combine(ModelMerger modelTreeMerger, ModelTree modelTree){
        return modelTreeMerger == null ? new ModelMerger(modelTree) : modelTreeMerger.merge(modelTree);
    }

    public ModelMerger merge(ModelTree modelTree) {
        this.name = modelTree.getName();
        mergeField(this.bigStringField, modelTree.getBigStringField(), BigStringFieldLiteralMerger::new);
        mergeField(this.binaryField, modelTree.getBinaryField(), BinaryFieldLiteralMerger::new);
        mergeField(this.booleanField, modelTree.getBooleanField(), BooleanFieldLiteralMerger::new);
        mergeField(this.dateField, modelTree.getDateField(), DateFieldLiteralMerger::new);
        mergeField(this.dateTimeField, modelTree.getDateTimeField(), DateTimeFieldLiteralMerger::new);
        mergeField(this.decimalField, modelTree.getDecimalField(), DecimalFieldLiteralMerger::new);
        mergeField(this.floatField, modelTree.getFloatField(), FloatFieldLiteralMerger::new);
        mergeField(this.intField, modelTree.getIntField(), IntFieldLiteralMerger::new);
        mergeField(this.longField, modelTree.getLongField(), LongFieldLiteralMerger::new);
        mergeField(this.stringField, modelTree.getStringField(), StringFieldLiteralMerger::new);
        mergeField(this.timeField, modelTree.getTimeField(), TimeFieldLiteralMerger::new);

        mergeField(this.otoField, modelTree.getOtoField(), OtoFieldLiteralMerger::new);
        mergeField(this.otmField, modelTree.getOtmField(), OtmFieldLiteralMerger::new);
        mergeField(this.mtoField, modelTree.getMtoField(), MtoFieldLiteralMerger::new);
        mergeField(this.mtmField, modelTree.getMtmField(), MtmFieldLiteralMerger::new);
        return this;
    }

    private <T> void mergeField(Map<String, FieldMerger<T>> containers,
                                Map<String, FieldNode<T>> nodes,
                                Function<T, FieldMerger<T>> producer) {
        for (Map.Entry<String, FieldNode<T>> f : nodes.entrySet()) {
            FieldMerger<T> merger = producer.apply(f.getValue().getCurrent());
            containers.put(f.getKey(),
                    recursiveMergeChild(merger.merge(f.getValue().getCurrent()), f.getValue()));
        }
    }

    private <T> FieldMerger<T> recursiveMergeChild(FieldMerger<T> merger, FieldNode<T> node) {
        for (FieldNode<T> child : node.getChilds()) {
            merger = recursiveMergeChild(merger.merge(child.getCurrent()), child);
        }
        return merger;
    }

    public ModelMerged toMerged() {
        ModelMergedImpl impl = new ModelMergedImpl(this.name);
        impl.bigStringField = this.bigStringField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.binaryField = this.binaryField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.booleanField = this.booleanField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.dateField = this.dateField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.dateTimeField = this.dateTimeField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.decimalField = this.decimalField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.floatField = this.floatField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.intField = this.intField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.intField = this.intField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.longField = this.longField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.stringField = this.stringField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.timeField = this.timeField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));

        impl.mtmField = this.mtmField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.mtoField = this.mtoField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.otmField = this.otmField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        impl.otoField = this.otoField.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().toValue()));
        return impl;

    }
}
