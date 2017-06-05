package org.platypus.erp.module.base;

import com.github.javaparser.JavaParser;
import org.platypus.builder.core.ReflectiveServiceParser;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class Main {
    public static void main(String[] args) {

        JavaParser.parse(Main.class.getResourceAsStream("test.java"));
    }
}
