package org.platypus.builder.core.views.list.generator;

import j2html.TagCreator;
import j2html.tags.ContainerTag;
import org.platypus.builder.core.views.list.structure.ListView;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.li;
import static j2html.TagCreator.link;
import static j2html.TagCreator.style;
import static j2html.TagCreator.title;
import static j2html.TagCreator.main;
import static org.platypus.builder.core.views.list.generator.PlatypusWeb.platypus_data_table;
import static org.platypus.builder.core.views.list.generator.WebComponent.domModule;
import static org.platypus.builder.core.views.list.generator.WebComponent.template;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class MainGenerator {



    public void generate(ListView listView){





        domModule().withId("platypus-view-" + listView.getTarget() + "-list")
                .with(
                        template().with(
                                style()
                        )
                        .with(
                                platypus_data_table()
                                .attr("target", listView.getTarget())
                                .withId(listView.getId())
                        )
                );



        System.out.println(html().with(
                head().with(
                        title("Title"),
                        link().withRel("stylesheet").withHref("/css/main.css")
                ),
                body().with(
                        main().with(
                                h1("Heading!")
                        )
                )
        ).render());
    }


}
