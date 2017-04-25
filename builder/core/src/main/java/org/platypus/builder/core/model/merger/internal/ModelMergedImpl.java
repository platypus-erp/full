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
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
class ModelMergedImpl implements ModelMerged {
    final String name;
    Set<MultiColumnUniqueKey> multiColumnUniqueKeys;
    Map<String, MetaInfoBigStringField> bigStringField;
    Map<String, MetaInfoBinaryField> binaryField;
    Map<String, MetaInfoBooleanField> booleanField;
    Map<String, MetaInfoDateField> dateField;
    Map<String, MetaInfoDateTimeField> dateTimeField;
    Map<String, MetaInfoDecimalField> decimalField;
    Map<String, MetaInfoFloatField> floatField;
    Map<String, MetaInfoIntField> intField;
    Map<String, MetaInfoLongField> longField;
    Map<String, MetaInfoStringField> stringField;
    Map<String, MetaInfoTimeField> timeField;

    public ModelMergedImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<MultiColumnUniqueKey> getMultiColumnUniqueKeys() {
        return Collections.unmodifiableSet(multiColumnUniqueKeys);
    }

    @Override
    public Map<String, MetaInfoBigStringField> getBigStringField() {
        return Collections.unmodifiableMap(bigStringField);
    }

    @Override
    public Map<String, MetaInfoBinaryField> getBinaryField() {
        return Collections.unmodifiableMap(binaryField);
    }

    @Override
    public Map<String, MetaInfoBooleanField> getBooleanField() {
        return Collections.unmodifiableMap(booleanField);
    }

    @Override
    public Map<String, MetaInfoDateField> getDateField() {
        return Collections.unmodifiableMap(dateField);
    }

    @Override
    public Map<String, MetaInfoDateTimeField> getDateTimeField() {
        return Collections.unmodifiableMap(dateTimeField);
    }

    @Override
    public Map<String, MetaInfoDecimalField> getDecimalField() {
        return Collections.unmodifiableMap(decimalField);
    }

    @Override
    public Map<String, MetaInfoFloatField> getFloatField() {
        return Collections.unmodifiableMap(floatField);
    }

    @Override
    public Map<String, MetaInfoIntField> getIntField() {
        return Collections.unmodifiableMap(intField);
    }

    @Override
    public Map<String, MetaInfoLongField> getLongField() {
        return Collections.unmodifiableMap(longField);
    }

    @Override
    public Map<String, MetaInfoStringField> getStringField() {
        return Collections.unmodifiableMap(stringField);
    }

    @Override
    public Map<String, MetaInfoTimeField> getTimeField() {
        return Collections.unmodifiableMap(timeField);
    }
}
