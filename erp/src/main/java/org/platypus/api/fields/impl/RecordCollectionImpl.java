package org.platypus.api.fields.impl;

import org.platypus.api.PlatypusField;
import org.platypus.api.Record;
import org.platypus.api.RecordCollection;
import org.platypus.api.query.QueryPath;
import org.platypus.api.query.projection.PProjection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class RecordCollectionImpl<R extends Record, RI extends R, RC extends RecordCollection<R>> extends AbstractFieldImpl<List<RI>> implements PlatypusField<List<RI>>, RecordCollection<R> {

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

    @Override
    public PProjection getProjection() {
        return null;
    }

    //<editor-fold desc="Methode to aggregate">

    @Override
    public <R1 extends R> Set<R1> asSet(Class<R1> record) {
        return null;
    }

    @Override
    public <R1 extends R> List<R1> asList(Class<R1> record) {
        return null;
    }

    @Override
    public <R1 extends R> R1 first() {
        return null;
    }

    @Override
    public <R1 extends R> R1 first(Class<R1> r1Class) {
        return null;
    }

    @Override
    public <R1 extends R> R1 last() {
        return null;
    }

    @Override
    public <R1 extends R> R1 last(Class<R1> r1Class) {
        return null;
    }

    @Override
    public <R1 extends R> R1 requiredOne() {
        return null;
    }

    @Override
    public <R1 extends R> R1 requiredOne(Class<R1> r1Class) {
        return null;
    }

    @Override
    public boolean isSingleValue() {
        return false;
    }

    //</editor-fold>
}
