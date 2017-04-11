package org.platypus.sample.depends;

import java.io.InputStream;

/**
 * @author chmuchme
 * @since 0.1
 * on 31/03/17.
 */
public interface ResourceLoader {

    default InputStream getAsStream(String pathTo, String fileNameParam) {
        return this.getClass().getResourceAsStream(
                pathTo +
                        "/" +
                        String.format(getDescriptor().name(), fileNameParam) +
                        "." + getDescriptor().ext());
    }

    /**
     * This method will be private in Java9
     */
    default ResourcesLoaderDescriptor getDescriptor(){
        return this.getClass().getAnnotation(ResourcesLoaderDescriptor.class);
    }

}
