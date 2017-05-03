package org.platypus.builder.core.views.list.generator;

import j2html.TagCreator;
import j2html.tags.ContainerTag;
import j2html.tags.EmptyTag;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class WebComponent {


    public static ContainerTag domModule() {
        return new DomModule("dom-module");
    }

    public static ContainerTag template() {
        return new DomModule("dom-module");
    }

    public static ContainerTag style() {
        return TagCreator.style();
    }
    public static EmptyTag link() {
        return TagCreator.link();
    }
}
