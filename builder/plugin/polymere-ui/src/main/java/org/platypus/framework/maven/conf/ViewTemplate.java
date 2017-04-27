package org.platypus.framework.maven.conf;

import static java.util.Objects.requireNonNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ViewTemplate {

    public enum ViewType{
        LIST("list-view.html")
        ;
        public final String fileName;

        ViewType(String fileName) {
            this.fileName = fileName;
        }
    }

    private final ViewType viewType;
    private Class classForTemplateLoading;
    private final String templateName;

    public static ViewTemplate list(String templateName){
        return new ViewTemplate(ViewType.LIST, null, templateName);
    }

    public static ViewTemplate list(String templateName, Class classForTemplateLoading){
        return new ViewTemplate(ViewType.LIST, classForTemplateLoading, templateName);
    }

    private ViewTemplate(ViewType viewType, Class classForTemplateLoading, String templateName) {
        this.viewType = requireNonNull(viewType);
        this.classForTemplateLoading = classForTemplateLoading;
        this.templateName = requireNonNull(templateName);
    }

    public ViewType getViewType() {
        return viewType;
    }

    public Class getClassForTemplateLoading() {
        return classForTemplateLoading;
    }

    public String getTemplateName() {
        return templateName;
    }

    public ViewTemplate setDefaultClassForTemplateLoading(Class defaultClass){
        if (classForTemplateLoading == null){
            this.classForTemplateLoading = defaultClass;
        }
        requireNonNull(this.classForTemplateLoading);
        return this;
    }
}
