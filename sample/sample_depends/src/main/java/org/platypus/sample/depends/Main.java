package org.platypus.sample.depends;

import org.platypus.builder.core.PlatypusBuilder;

/**
 * @author chmuchme
 * @since 0.1
 * on 11/04/17.
 */
public class Main {

    public static void main(String[] args) {
        PlatypusBuilder.main(
                "--directory=/home/chmuchme/WorkSpace/PLATYPUS/full/sample/sample_depends",
                "--modulename=sample_depends",
                "--plugins=[display_tree_module(enable::false - opt::[output:TXT])]",
                "--defaultpkg=org.platypus.sample.sample_depends",
                "--moduleVersion=1",
                "--depends=null",
                "--moduleQuickDesc=null",
                "--shortDesc=/home/chmuchme/WorkSpace/PLATYPUS/full/sample/sample_depends/src/main/ressources/org.platypus.sample.sample_depends/short-desc.adoc",
                "--longDesc=/home/chmuchme/WorkSpace/PLATYPUS/full/sample/sample_depends/src/main/ressources/org.platypus.sample.sample_depends/long-desc.adoc");
    }
}
