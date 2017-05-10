package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.query.QueryPath;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface LongField extends UnmutatableLongField, GenericField<Long> {

    static LongField of(long value){
        return new EmptyLongField(value);
    }

    static LongField empty(){
        return new EmptyLongField();
    }

    class EmptyLongField implements LongField{

        private EmptyLongField(){
            value = 0;
        }

        private EmptyLongField(long value){
            this.value = value;
        }

        long value;
        @Override
        public String getName() {
            throw new UnsupportedOperationException("This method can't be called");
        }

        @Override
        public QueryPath getPath() {
            throw new UnsupportedOperationException("This method can't be called");
        }

        @Override
        public void set(Long value) {
            this.value = value;
        }

        @Override
        public Long get() {
            return value;
        }

        @Override
        public boolean bool() {
            return value != 0;
        }

        @Override
        public boolean isEmpty() {
            return bool();
        }

        @Override
        public Long getOrDefault(Long defaultValue) {
            return value != 0 ? value : defaultValue;
        }

        @Override
        public Long getOrDefault() {
            return getOrDefault(0L);
        }

        @Override
        public Long getDefaultValue() {
            return 0L;
        }
    }
}
