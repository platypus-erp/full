package org.platypus.builder.core.views.list.generator;

import j2html.tags.EmptyTag;

/**
 * @author chmuchme
 * @since 0.1
 * on 01/05/17.
 */
public class Polymere {

    @PolymereWebComponennt(name = "paper-toggle-button", linkDoc = "")
    public static EmptyTag paper_toggle_button(){
        return new EmptyTag("paper-toggle-button");
    }

    @PolymereWebComponennt(name = "paper-check-box", linkDoc = "")
    public static EmptyTag paper_check_box(){
        return new EmptyTag("paper-check-box");
    }
}
