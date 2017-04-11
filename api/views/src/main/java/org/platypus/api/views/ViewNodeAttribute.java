package org.platypus.api.views;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public interface ViewNodeAttribute {

    String getAsString(String attributeName);

    String getAsStringOrDefault(String attributeName, String defaultValue);

    int getAsIntOrDefault(String attributeName, int defaultValue);

    int getAsInt(String attributeName);

    float getAsFloat(String attributeName);

    float getAsFloatOrDefault(String attributeName, float defaultValue);

    <T extends Enum<T>> T getAsEnum(String attributeName, Class<T> enumClass);

    <T extends Enum<T>> T getAsEnumOrDefault(String attributeName, Class<T> enumClass, T defaultValue);
}
