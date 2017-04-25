package org.platypus.builder.core.model.tree.internal;


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
import org.platypus.builder.core.model.tree.FieldNode;
import org.platypus.builder.core.model.tree.ModelTree;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class ModelTreeImpl implements ModelTree {

    private final String name;

    public ModelTreeImpl(String name) {
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

        ModelTreeImpl modelTree = (ModelTreeImpl) o;

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
