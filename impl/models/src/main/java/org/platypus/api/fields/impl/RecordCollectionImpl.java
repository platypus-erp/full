package org.platypus.api.fields.impl;

import org.platypus.api.GenericField;
import org.platypus.api.SetPathable;
import org.platypus.api.query.QueryPath;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.TypedRecordCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.*;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class RecordCollectionImpl<R extends Record, RI extends R, RC extends RecordCollection<R>> extends AbstractFieldImpl<List<RI>> implements GenericField<List<RI>>, RecordCollection<R> {

    private final Supplier<List<RI>> defaultValue = ArrayList<RI>::new;

    public RecordCollectionImpl(String table,
                                String name,
                                Supplier<QueryPath> getPath,
                                Supplier<List<RI>> getter,
                                Consumer<List<RI>> setter) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public List<RI> getDefaultValue() {
        return new ArrayList<>();
    }

    //<editor-fold desc="Methode to impl">
    @Override
    public <R1 extends R> Class<R1> getType() {
        return null;
    }

    @Override
    public <R1 extends R> Set<R1> unWrap(Class<R1> record) {
        return null;
    }

    @Override
    public <R1 extends R> List<R1> unWrapAsList(Class<R1> record) {
        return null;
    }

    @Override
    public <R1 extends R> TypedRecordCollection<R1> type() {
        return null;
    }

    @Override
    public <R1 extends R> TypedRecordCollection<R1> type(Class<R1> type) {
        return null;
    }

    @Override
    public RecordCollection where(Object predicate) {
        return null;
    }

    @Override
    public <R1 extends R> RecordCollection filter(Predicate<R1> predicate) {
        return null;
    }

    @Override
    public RecordCollection sort(Object predicate) {
        return null;
    }

    @Override
    public <R1 extends R> RecordCollection orderBy(Class<R1> type, boolean asc, Object... field) {
        return null;
    }

    @Override
    public <R1 extends R> R1 first() {
        return null;
    }

    @Override
    public <R1 extends R> R1 last() {
        return null;
    }

    @Override
    public void requiredOne() {

    }

    @Override
    public boolean isSingleValue() {
        return false;
    }

    @Override
    public <R1 extends R> boolean replace(R1 record) {
        return false;
    }

    @Override
    public <R1 extends R> boolean merge(R1 record, BiFunction<R1, R1, R1> mergeFunction) {
        return false;
    }

    @Override
    public <R1 extends R> boolean remove(R1 record) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<R> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(R r) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends R> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
    //</editor-fold>
}
