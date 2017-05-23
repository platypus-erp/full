package org.platypus.builder.core.field.tree.internal;


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
import org.platypus.builder.core.field.tree.FieldNode;
import org.platypus.builder.core.field.tree.FieldTree;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class FieldTreeImpl implements FieldTree {

    private final String name;

    public FieldTreeImpl(String name) {
        this.name = name;
    }

    private Map<String, FieldNode<MetaInfoStringField>> stringField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoLongField>> longField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoIntField>> intField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoFloatField>> floatField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoDecimalField>> decimalField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoBigStringField>> bigStringField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoBinaryField>> binaryField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoDateField>> dateField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoDateTimeField>> dateTimeField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoTimeField>> timeField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoBooleanField>> booleanField = new HashMap<>();

    private Map<String, FieldNode<MetaInfoOneToOneField>> otoField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoOneToManyField>> otmField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoManyToManyField>> mtmField = new HashMap<>();
    private Map<String, FieldNode<MetaInfoManyToOneField>> mtoField = new HashMap<>();

    private Map<String, FieldNodeImpl<MetaInfoStringField>> stringFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoLongField>> longFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoBooleanField>> booleanFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoIntField>> intFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoFloatField>> floatFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoDecimalField>> decimalFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoBigStringField>> bigStringFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoBinaryField>> binaryFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoDateField>> dateFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoDateTimeField>> dateTimeFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoTimeField>> timeFieldLast = new HashMap<>();

    private Map<String, FieldNodeImpl<MetaInfoOneToOneField>> otoFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoOneToManyField>> otmFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoManyToManyField>> mtmFieldLast = new HashMap<>();
    private Map<String, FieldNodeImpl<MetaInfoManyToOneField>> mtoFieldLast = new HashMap<>();

    @Override
    public Map<String, FieldNode<MetaInfoStringField>> getStringField() {
        return stringField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoLongField>> getLongField() {
        return longField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoIntField>> getIntField() {
        return intField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoFloatField>> getFloatField() {
        return floatField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoDecimalField>> getDecimalField() {
        return decimalField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoBigStringField>> getBigStringField() {
        return bigStringField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoBinaryField>> getBinaryField() {
        return binaryField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoDateField>> getDateField() {
        return dateField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoDateTimeField>> getDateTimeField() {
        return dateTimeField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoTimeField>> getTimeField() {
        return timeField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoBooleanField>> getBooleanField() {
        return booleanField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoOneToOneField>> getOtoField() {
        return otoField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoOneToManyField>> getOtmField() {
        return otmField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoManyToManyField>> getMtmField() {
        return mtmField;
    }

    @Override
    public Map<String, FieldNode<MetaInfoManyToOneField>> getMtoField() {
        return mtoField;
    }

    public void addStringField(String fieldName, FieldNodeImpl<MetaInfoStringField> node) {
        add(fieldName, node, stringField, stringFieldLast);
    }

    public void addLongField(String fieldName, FieldNodeImpl<MetaInfoLongField> node) {
        add(fieldName, node, longField, longFieldLast);
    }

    public void addIntField(String fieldName, FieldNodeImpl<MetaInfoIntField> node) {
        add(fieldName, node, intField, intFieldLast);
    }

    public void addBooleanField(String fieldName, FieldNodeImpl<MetaInfoBooleanField> node) {
        add(fieldName, node, booleanField, booleanFieldLast);
    }

    public void addFloatField(String fieldName, FieldNodeImpl<MetaInfoFloatField> node) {
        add(fieldName, node, floatField, floatFieldLast);
    }

    public void addDecimalField(String fieldName, FieldNodeImpl<MetaInfoDecimalField> node) {
        add(fieldName, node, decimalField, decimalFieldLast);
    }

    public void addBigStringField(String fieldName, FieldNodeImpl<MetaInfoBigStringField> node) {
        add(fieldName, node, bigStringField, bigStringFieldLast);
    }

    public void addBinaryField(String fieldName, FieldNodeImpl<MetaInfoBinaryField> node) {
        add(fieldName, node, binaryField, binaryFieldLast);
    }

    public void addDateField(String fieldName, FieldNodeImpl<MetaInfoDateField> node) {
        add(fieldName, node, dateField, dateFieldLast);
    }

    public void addDateTimeField(String fieldName, FieldNodeImpl<MetaInfoDateTimeField> node) {
        add(fieldName, node, dateTimeField, dateTimeFieldLast);
    }

    public void addTimeField(String fieldName, FieldNodeImpl<MetaInfoTimeField> node) {
        add(fieldName, node, timeField, timeFieldLast);
    }

    public void addOtoField(String fieldName, FieldNodeImpl<MetaInfoOneToOneField> node) {
        add(fieldName, node, otoField, otoFieldLast);
    }

    public void addOtmField(String fieldName, FieldNodeImpl<MetaInfoOneToManyField> node) {
        add(fieldName, node, otmField, otmFieldLast);
    }

    public void addMtoField(String fieldName, FieldNodeImpl<MetaInfoManyToOneField> node) {
        add(fieldName, node, mtoField, mtoFieldLast);
    }

    public void addMtmField(String fieldName, FieldNodeImpl<MetaInfoManyToManyField> node) {
        add(fieldName, node, mtmField, mtmFieldLast);
    }


    private <T> void add(String fieldName, FieldNodeImpl<T> node, Map<String, FieldNode<T>> map, Map<String, FieldNodeImpl<T>> mapLast) {
        if (map.putIfAbsent(fieldName, node) == null) {
            mapLast.put(fieldName, node);
        } else {
            mapLast.get(fieldName).addChild(node);
            mapLast.put(fieldName, node);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldTreeImpl modelTree = (FieldTreeImpl) o;

        return name != null ? name.equals(modelTree.name) : modelTree.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
