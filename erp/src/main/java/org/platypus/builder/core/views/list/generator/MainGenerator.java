package org.platypus.builder.core.views.list.generator;

import j2html.TagCreator;
import org.platypus.builder.core.views.list.structure.ListView;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.link;
import static j2html.TagCreator.main;
import static j2html.TagCreator.script;
import static j2html.TagCreator.style;
import static j2html.TagCreator.title;
import static org.platypus.builder.core.views.list.generator.WebComponent.domModule;
import static org.platypus.builder.core.views.list.generator.WebComponent.template;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class MainGenerator {


    public void generate(ListView listView) {


        String idDomeModule = "platypus-view-" + listView.getTarget() + "-list";
        String page = domModule().withId(idDomeModule)
                .with(
                        template().with(
                                TagCreator.style()
                        )
                                .with(new PlatypusDataTable(listView))
                ).with(TagCreator.script().withText("Polymer({is: '" + idDomeModule + "'});")
        ).render();
        System.out.println(PrettyPrinter.prettyFormat(page));

        System.out.println(TagCreator.html().with(
                TagCreator.head().with(
                        TagCreator.title("Title"),
                        TagCreator.link().withRel("stylesheet").withHref("/css/main.css")
                ),
                TagCreator.body().with(
                        TagCreator.main().with(
                                TagCreator.h1("Heading!")
                        )
                )
        ).render());
    }


}
