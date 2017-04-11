package org.platypus.sample.depends.desc;

import org.platypus.sample.depends.ResourceLoader;
import org.platypus.sample.depends.ResourcesLoaderDescriptor;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
@ResourcesLoaderDescriptor(name = "long_desc", ext = "adoc")
public final class LongDescLoader implements ResourceLoader {
}
