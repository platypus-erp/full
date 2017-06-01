package org.platypus.api.fields;


import org.platypus.api.PlatypusField;
import org.platypus.api.query.domain.field.ComparableFieldPredicate;
import org.platypus.api.query.domain.visitor.PPredicate;

import java.util.Collection;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface LongField extends PlatypusField<Long> , ComparableFieldPredicate<Long>{

    @Override
    default PPredicate isNull() {
        return null;
    }

    @Override
    default PPredicate isNotNull() {
        return null;
    }

    @Override
    default PPredicate eq(Long value) {
        return null;
    }

    @Override
    default PPredicate lessThan(Long value) {
        return null;
    }

    @Override
    default PPredicate lessOrEq(Long value) {
        return null;
    }

    @Override
    default PPredicate moreThan(Long value) {
        return null;
    }

    @Override
    default PPredicate moreOrEq(Long value) {
        return null;
    }

    @Override
    default PPredicate between(Long value1, Long value2) {
        return null;
    }

    @Override
    default PPredicate in(Collection<Long> values) {
        return null;
    }

    @Override
    default PPredicate in(Long... values) {
        return null;
    }

//    static LongField of(long value){
//        return new EmptyLongField(value);
//    }
//
//    static LongField empty(){
//        return new EmptyLongField();
//    }
//
//    class EmptyLongField implements LongField{
//
//        private EmptyLongField(){
//            value = 0;
//        }
//
//        private EmptyLongField(long value){
//            this.value = value;
//        }
//
//        @Override
//        public QueryPathImpl resolve(QueryPathImpl queryPath) {
//            throw new UnsupportedOperationException("This method can't be called");
//        }
//
//        long value;
//        @Override
//        public String getName() {
//            throw new UnsupportedOperationException("This method can't be called");
//        }
//
//        @Override
//        public QueryPathImpl getPath() {
//            throw new UnsupportedOperationException("This method can't be called");
//        }
//
//        @Override
//        public void set(Long value) {
//            this.value = value;
//        }
//
//        @Override
//        public Long newRecord() {
//            return value;
//        }
//
//        @Override
//        public boolean bool() {
//            return value != 0;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return bool();
//        }
//
//        @Override
//        public Long getOrDefault(Long defaultValue) {
//            return value != 0 ? value : defaultValue;
//        }
//
//        @Override
//        public Long getOrDefault() {
//            return getOrDefault(0L);
//        }
//
//        @Override
//        public Long getDefaultValue() {
//            return 0L;
//        }
//    }
}
