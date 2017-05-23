package org.platypus.builder.core.views.list.generator;

import j2html.tags.ContainerTag;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class PlatypusWeb {

    public static ContainerTag platypus_data_table(){
        return new ContainerTag("platypus-data-table");
    }

    public static ContainerTag platypusDataTableColumn() {
        return new ContainerTag("data-table-column");
    }
}
