package org.platypus.builder.core.model.tree;


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

import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface ModelTree {
    String getName();

    Map<String, FieldNode<MetaInfoBigStringField>> getBigStringField();
    Map<String, FieldNode<MetaInfoBinaryField>> getBinaryField();
    Map<String, FieldNode<MetaInfoBooleanField>> getBooleanField();
    Map<String, FieldNode<MetaInfoDateField>> getDateField();
    Map<String, FieldNode<MetaInfoDateTimeField>> getDateTimeField();
    Map<String, FieldNode<MetaInfoDecimalField>> getDecimalField();
    Map<String, FieldNode<MetaInfoFloatField>> getFloatField();
    Map<String, FieldNode<MetaInfoIntField>> getIntField();
    Map<String, FieldNode<MetaInfoLongField>> getLongField();
    Map<String, FieldNode<MetaInfoStringField>> getStringField();
    Map<String, FieldNode<MetaInfoTimeField>> getTimeField();

    Map<String, FieldNode<MetaInfoOneToOneField>> getOtoField();
    Map<String, FieldNode<MetaInfoOneToManyField>> getOtmField();
    Map<String, FieldNode<MetaInfoManyToManyField>> getMtmField();
    Map<String, FieldNode<MetaInfoManyToOneField>> getMtoField();
}
