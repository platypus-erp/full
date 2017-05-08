package org.platypus.api.fields.metainfo;


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
