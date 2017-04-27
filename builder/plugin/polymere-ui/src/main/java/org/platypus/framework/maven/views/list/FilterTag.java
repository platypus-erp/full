package org.platypus.framework.maven.views.list;

/**
 * represente le tag xml <filter value="contains|start|end" case-sensitive="true|false"/>
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class FilterTag {

    private Value value;
    private boolean caseSensitive;

    private FilterTag(Value value, boolean caseSensitive) {
        this.value = value;
        this.caseSensitive = caseSensitive;
    }

    public static FilterTag createDefaultTag(){
        return new FilterTag(Value.CONTAINS, false);
    }

    public enum Value{
        CONTAINS,START,END
    }

    public Value getValue(){
        return value;
    }

    public boolean isCaseSensitive(){
        return caseSensitive;
    }

    public FilterTag setValue(Value value) {
        this.value = value;
        return this;
    }

    public FilterTag setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }
}
