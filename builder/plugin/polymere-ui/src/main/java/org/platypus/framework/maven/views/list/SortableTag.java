package org.platypus.framework.maven.views.list;

/**
 * <sortable value="true|false"/>
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class SortableTag {

    private boolean value;

    public static SortableTag createDefaultValue(){
        return new SortableTag(true);
    }
    
    public SortableTag(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }
}
