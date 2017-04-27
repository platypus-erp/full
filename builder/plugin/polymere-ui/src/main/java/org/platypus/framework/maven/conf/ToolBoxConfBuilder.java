package org.platypus.framework.maven.conf;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ToolBoxConfBuilder {

    private Class classForAllTemplateLoading;
    private EnumMap<ViewTemplate.ViewType, ViewTemplate> templates = new EnumMap<>(ViewTemplate.ViewType.class);
    private Set<Path> pathsToCopy = new HashSet<>();

    public ToolBoxConfBuilder setClassForAllTemplateLoading(Class classForAllTemplateLoading) {
        requireNonNull(classForAllTemplateLoading);
        this.classForAllTemplateLoading = classForAllTemplateLoading;
        return this;
    }

    public ToolBoxConfBuilder addViewTemplate(ViewTemplate viewTemplate) {
        requireNonNull(viewTemplate);
        if (viewTemplate.getClassForTemplateLoading() == null && this.classForAllTemplateLoading == null){
            throw new RuntimeException();
        }
        templates.put(viewTemplate.getViewType(), viewTemplate.setDefaultClassForTemplateLoading(classForAllTemplateLoading));
        return this;
    }

    public ToolBoxConfBuilder addUrlToCopy(URL url){
        return addPathToCopy(Paths.get(requireNonNull(url).getPath()));
    }

    public ToolBoxConfBuilder addPathToCopy(Path path){
        requireNonNull(path);
        if (path.isAbsolute()){
            throw new RuntimeException("The path can't be absolute value ["+path.toString()+"]");
        }
        pathsToCopy.add(path);
        return this;
    }

    public ToolBoxConf build(){
        return new ToolBoxConfImpl(templates, pathsToCopy);
    }
}
