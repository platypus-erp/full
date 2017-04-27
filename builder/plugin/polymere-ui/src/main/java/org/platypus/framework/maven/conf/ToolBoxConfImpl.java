package org.platypus.framework.maven.conf;

import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class ToolBoxConfImpl implements ToolBoxConf {

    private final EnumMap<ViewTemplate.ViewType, ViewTemplate> templates;
    private final Set<Path> pathsToCopy;

    public ToolBoxConfImpl(EnumMap<ViewTemplate.ViewType, ViewTemplate> templates, Set<Path> pathsToCopy) {
        this.templates = templates;
        this.pathsToCopy = pathsToCopy;
    }

    @Override
    public ViewTemplate getTemplate(ViewTemplate.ViewType type) {
        return templates.get(type);
    }

    @Override
    public Set<Path> getPathsToCopy() {
        return pathsToCopy;
    }
}
