package org.platypus.api.fields.metainfo;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 18/04/17.
 */
public interface MetaInfoFieldModel {

    Set<MetaInfoStringField> stringField();
    Set<MetaInfoLongField> longField();
    Set<MetaInfoBooleanField> booleanField();
    Set<MetaInfoIntField> intField();
    Set<MetaInfoFloatField> floatField();
    Set<MetaInfoDecimalField> decimalField();
    Set<MetaInfoBigStringField> bigStringField();
    Set<MetaInfoBinaryField> binaryField();
    Set<MetaInfoDateField> dateField();
    Set<MetaInfoDateTimeField> dateTimeField();
    Set<MetaInfoTimeField> timeField();
}
