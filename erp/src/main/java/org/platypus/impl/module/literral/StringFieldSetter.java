package org.platypus.impl.module.literral;


import org.platypus.api.Bool;
import org.platypus.api.annotations.field.RemoveSpaceType;
import org.platypus.api.annotations.field.RequiredType;
import org.platypus.api.fields.metainfo.MetaInfoStringField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface StringFieldSetter extends MetaInfoStringField, BasicFieldDef{

    static StringFieldSetter of(String name){
        return new StringFieldLiteral(name);
    }

    StringFieldSetter setMatch(String match);
    StringFieldSetter setRemoveSpace(RemoveSpaceType removeSpace);
    StringFieldSetter setMaxSize(int maxSize);
    StringFieldSetter setMinSize(int minSize);
    StringFieldSetter setDefaultValue(String defaultValue);
    StringFieldSetter setRequired(RequiredType required);
    StringFieldSetter setInsertable(Bool insertable);
    StringFieldSetter setUpdatable(Bool updatable);
    StringFieldSetter setReadonly(Bool readonly);
    StringFieldSetter setColumnDoc(String columnDoc);
    StringFieldSetter setUniqueHint(String uniqueHint);
    StringFieldSetter setEraseWithYours(boolean eraseWithYours);
    StringFieldSetter setComputed(boolean computed);
    StringFieldSetter setRelated(boolean related);
    StringFieldSetter setPathRelated(String[] pathRelated);
    StringFieldSetter setStore(Bool store);
}
