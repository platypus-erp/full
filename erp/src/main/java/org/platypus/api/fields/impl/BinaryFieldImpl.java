package org.platypus.api.fields.impl;

import org.platypus.api.query.tmp.QueryPathImpl;
import org.platypus.api.fields.BinaryField;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class BinaryFieldImpl extends AbstractFieldImpl<byte[]> implements BinaryField {

    public BinaryFieldImpl(String table, String name, Supplier<QueryPathImpl> getPath, Supplier<byte[]> getter, Consumer<byte[]> setter) {
        super(table, name, getPath, getter, setter);
    }

    @Override
    public byte[] getDefaultValue() {
        return new byte[0];
    }
}
