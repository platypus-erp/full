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

    /**
     * Copy of StringUtils.capitalize
     * <p>Capitalizes a String changing the first character to title case as
     * per {@link Character#toTitleCase(char)}. No other characters are changed.</p>
     *
     * A {@code null} input String returns {@code null}.</p>
     *
     * <pre>
     * StringUtils.capitalize(null)  = null
     * StringUtils.capitalize("")    = ""
     * StringUtils.capitalize("cat") = "Cat"
     * StringUtils.capitalize("cAt") = "CAt"
     * StringUtils.capitalize("'cat'") = "'cat'"
     * </pre>
     *
     * @param str the String to capitalize, may be null
     * @return the capitalized String, {@code null} if null String input
     * @since 2.0
     */
    public static String capitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final char firstChar = str.charAt(0);
        final char newChar = Character.toTitleCase(firstChar);
        if (firstChar == newChar) {
            // already capitalized
            return str;
        }

        char[] newChars = new char[strLen];
        newChars[0] = newChar;
        str.getChars(1,strLen, newChars, 1);
        return String.valueOf(newChars);
    }
}
