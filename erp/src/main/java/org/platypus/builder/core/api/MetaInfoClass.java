package org.platypus.builder.core.api;

import java.util.Arrays;
import java.util.List;

/**
 * @author chmuchme
 * @since 0.1
 * on 03/06/17.
 */
public class MetaInfoClass {

    public final String pkg;
    public final List<String> type;

    public MetaInfoClass(String pkg, String... type) {
        this.pkg = pkg;
        this.type = Arrays.asList(type);
    }

    public MetaInfoClass(String pkg, List<String> type) {
        this.pkg = pkg;
        this.type = type;
    }
}
