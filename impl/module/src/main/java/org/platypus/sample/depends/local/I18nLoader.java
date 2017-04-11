package org.platypus.sample.depends.local;

import org.platypus.sample.depends.ResourceLoader;
import org.platypus.sample.depends.ResourcesLoaderDescriptor;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
@ResourcesLoaderDescriptor(name = "local_%s", ext = "properties")
public final class I18nLoader implements ResourceLoader {
}
