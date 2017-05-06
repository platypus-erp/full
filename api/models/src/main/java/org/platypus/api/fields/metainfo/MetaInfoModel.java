package org.platypus.api.fields.metainfo;


import org.platypus.api.Namable;
import org.platypus.api.TypeModel;
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
public interface MetaInfoModel extends
        MetaInfoInheritModel,
        MetaInfoRootBasedModelModel,
        MetaInfoRootModel,
        MetaInfoTypableModel{

    String getClassName();
    String getPkg();
    String getModuleName();
//    Set<OneToManyFieldDefinition> oneToMany();
//    Set<OneToOneFieldDefinition> oneToOne();
//    Set<ManyToOneFieldDefinition> manyToOne();
//    Set<ManyToManyFieldDefinition> manyToMany();
//
//    Set<ComputedFieldDefinition> computed();
//    Set<RelatedFieldDefinition> related();
}
