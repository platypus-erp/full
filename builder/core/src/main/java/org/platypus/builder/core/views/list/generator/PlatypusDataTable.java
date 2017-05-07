package org.platypus.builder.core.views.list.generator;

import j2html.tags.ContainerTag;
import org.platypus.builder.core.views.list.structure.ListView;
import org.platypus.builder.core.views.list.structure.column.ListViewColumn;

import static org.platypus.builder.core.views.list.generator.WebComponent.template;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class PlatypusDataTable extends ContainerTag {
    public PlatypusDataTable(ListView listView) {
        super("platypus-data-table");
        attr("target", listView.getTarget());
        withId(listView.getId());
        ContainerTag dataTable = PlatypusWeb.platypus_data_table().withId("obj-id")
                .attr("hidden", null)
                .attr("header", "id")
                .attr("property", "id")
                .with(template().withText("{{value}}"));

        for (ListViewColumn col : listView.getDataTableView().getAllColumns()) {
            ContainerTag colum = PlatypusWeb.platypusDataTableColumn().withName(col.getHeaderLabelKey())
                    .attr("order", "" + col.getOrder())
                    .attr("filter-by", col.getPropertyName())
                    .with(
                            template().with(
                                    col.toContainerTag()
                            )
                    );
            dataTable.with(colum);
        }
        with(dataTable);
    }


}
