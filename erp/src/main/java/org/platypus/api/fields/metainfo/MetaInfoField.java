package org.platypus.api.fields.metainfo;

import org.platypus.api.Namable;
import org.platypus.api.fields.Bool;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public interface MetaInfoField extends Namable{

    Bool readonly();
}
