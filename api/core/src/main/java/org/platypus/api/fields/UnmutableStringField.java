package org.platypus.api.fields;


import org.platypus.api.UnmutableGenericField;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface UnmutableStringField extends UnmutableGenericField<String> {

    default boolean match(String regex){
        return match(regex, false);
    }
    default boolean match(String regex, boolean defaultValueIfEmpty){
        return isEmpty() ? defaultValueIfEmpty : this.get().matches(regex);
    }

}
