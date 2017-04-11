package org.platypus.api.module;


import org.platypus.api.Namable;
import org.platypus.api.fields.metainfo.MetaInfoBigStringField;
import org.platypus.api.fields.metainfo.MetaInfoBinaryField;
import org.platypus.api.fields.metainfo.MetaInfoDateField;
import org.platypus.api.fields.metainfo.MetaInfoDateTimeField;
import org.platypus.api.fields.metainfo.MetaInfoDecimalField;
import org.platypus.api.fields.metainfo.MetaInfoFloatField;
import org.platypus.api.fields.metainfo.MetaInfoIntField;
import org.platypus.api.fields.metainfo.MetaInfoLongField;
import org.platypus.api.fields.metainfo.MetaInfoStringField;
import org.platypus.api.fields.metainfo.MetaInfoTimeField;

import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface MetaInfoModel extends Namable{

    TypeModel getType();

    Set<MetaInfoStringField> stringField();
    Set<MetaInfoLongField> longField();
    Set<MetaInfoIntField> intField();
    Set<MetaInfoFloatField> floatField();
    Set<MetaInfoDecimalField> decimalField();
    Set<MetaInfoBigStringField> bigStringField();
    Set<MetaInfoBinaryField> binaryField();
    Set<MetaInfoDateField> dateField();
    Set<MetaInfoDateTimeField> dateTimeField();
    Set<MetaInfoTimeField> timeField();


//    Set<OneToManyFieldDefinition> oneToMany();
//    Set<OneToOneFieldDefinition> oneToOne();
//    Set<ManyToOneFieldDefinition> manyToOne();
//    Set<ManyToManyFieldDefinition> manyToMany();
//
//    Set<ComputedFieldDefinition> computed();
//    Set<RelatedFieldDefinition> related();
}
