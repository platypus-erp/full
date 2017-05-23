package org.platypus.builder.utils;


import org.platypus.api.Bool;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public final class ValuesUtils {

    public static Bool bool(Bool value, Bool actual) {
        return value == Bool.DEFAULT ? actual : value;
    }

    public static boolean isTrueOrDefault(Bool b) {
        return b != Bool.FALSE;
    }

    public static boolean isFalseOrDefault(Bool b) {
        return b != Bool.TRUE;
    }

    public static int intMax(int value, int actual) {
        return value == Integer.MAX_VALUE ? actual : value;
    }

    public static int intMin(int value, int actual) {
        return value == Integer.MIN_VALUE ? actual : value;
    }

    public static long longMax(long value, long actual) {
        return value == Long.MAX_VALUE ? actual : value;
    }

    public static long longMin(long value, long actual) {
        return value == Long.MIN_VALUE ? actual : value;
    }

    public static String str(String value, String actual) {
        return value == null || value.trim().isEmpty() ? actual : value;
    }

    public static float fltMin(float value, float actual) {
        return value == Float.MIN_VALUE ? actual : value;
    }

    public static float fltMax(float value, float actual) {
        return value == Float.MAX_VALUE ? actual : value;
    }

//    public static CascadeType[] toJpaCascadeType(PlatypusCascadeType[] platypusCascadeTypes, CascadeType... defaults) {
//        if (platypusCascadeTypes.length < 0) {
//            return defaults;
//        } else {
//            Arrays.sort(platypusCascadeTypes);
//            if (Arrays.binarySearch(platypusCascadeTypes, PlatypusCascadeType.NONE) >= 0) {
//                return new CascadeType[0];
//            }
//            if (Arrays.binarySearch(platypusCascadeTypes, PlatypusCascadeType.DEFAULT) >= 0) {
//                return defaults;
//            }
//            return Arrays.stream(platypusCascadeTypes)
//                    .map(p -> CascadeType.valueOf(p.toString()))
//                    .toArray(CascadeType[]::new);
//        }
//    }
}
