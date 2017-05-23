package org.platypus.api.fields;


import org.platypus.api.GenericField;

import java.math.BigDecimal;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DecimalField extends GenericField<BigDecimal> {


    void set(BigDecimal date);
}
