package org.platypus.builder.core.views.list.generator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author chmuchme
 * @since 0.1
 * on 06/05/17.
 */
public class PrettyPrinter {
    public static String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }

    public static String prettyFormat(String html, int indent) {
        Document doc = Jsoup.parseBodyFragment(html);
        doc.outputSettings().indentAmount(indent);
        return doc.body().html();
    }
}
