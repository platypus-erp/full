package org.platypus.api.fields;


import org.platypus.api.PlatypusField;

import java.math.BigDecimal;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public interface DecimalField extends PlatypusField<BigDecimal> {


    void set(BigDecimal date);
}
