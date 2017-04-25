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
import org.platypus.builder.core.model.merger.internal.MultiColumnUniqueKey;

import java.util.Map;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface ModelMerged {

    String getName();

    Map<String, MetaInfoBigStringField> getBigStringField();
    Map<String, MetaInfoBinaryField> getBinaryField();
    Map<String, MetaInfoBooleanField> getBooleanField();
    Map<String, MetaInfoDateField> getDateField();
    Map<String, MetaInfoDateTimeField> getDateTimeField();
    Map<String, MetaInfoDecimalField> getDecimalField();
    Map<String, MetaInfoFloatField> getFloatField();
    Map<String, MetaInfoIntField> getIntField();
    Map<String, MetaInfoLongField> getLongField();
    Map<String, MetaInfoStringField> getStringField();
    Map<String, MetaInfoTimeField> getTimeField();

    Set<MultiColumnUniqueKey> getMultiColumnUniqueKeys();
}
