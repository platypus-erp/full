package org.platypus.api.module;

import org.platypus.api.Namable;
import org.platypus.api.annotations.PlatypusVersion;

import java.util.Set;

/**
 * @author chmuchme
 * @since 0.1
 * on 30/03/17.
 */
public interface ModuleInfo extends Namable{

    String techincalName();

    String version();

    PlatypusVersion platypusVersion();

    Set<String> depends();
}
