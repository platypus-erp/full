package org.platypus.framework.maven.conf;

import java.nio.file.Path;
import java.util.Set;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public interface ToolBoxConf {

    ViewTemplate getTemplate(ViewTemplate.ViewType type);

    Set<Path> getPathsToCopy();
}
