package org.platypus.api.fields;


import org.platypus.api.GenericField;
import org.platypus.api.UnmutableGenericField;

import java.time.LocalTime;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface TimeField extends GenericField<LocalTime>,UnmutableGenericField<LocalTime> {
}
