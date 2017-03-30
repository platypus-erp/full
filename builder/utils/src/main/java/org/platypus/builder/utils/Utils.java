package org.platypus.builder.utils;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @version 0.1
 * @since 0.1
 */
public class Utils {
    private static Pattern SQL_PATTERN = Pattern.compile("([a-z])([A-Z]+)");
    private static String SQL_REPLACEMENT = "$1_$2";
    public static Function<String,String> TO_SQL = str -> SQL_PATTERN.matcher(str).replaceAll(SQL_REPLACEMENT).toLowerCase();
}
