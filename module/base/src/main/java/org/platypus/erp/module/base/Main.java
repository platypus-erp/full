package org.platypus.erp.module.base;

import org.platypus.builder.core.ReflectiveRootServiceParser;
import org.platypus.builder.core.service.MetaInfoBusinessMethod;

/**
 * @author chmuchme
 * @since 0.1
 * on 08/05/17.
 */
public class Main {
    public static void main(String[] args) {
//        String dir = args[0];
//        System.out.println(Arrays.toString(args));
//        PlatypusBuilder.main(
//                "--directory=" + dir,
//                "--modulename=base",
//                "--plugins=[display_tree_module(enable::false - opt::[output:TXT])]",
//                "--mainDir=" + dir + "/src/main/java",
//                "--modelsDir=" + dir + "/src/models/java",
//                "--generatedDir=" + dir + "/src/generated/java",
//                "--srcDirs=[" +
//                        dir + "/src/main/java," +
//                        dir + "/src/models/java," +
//                        dir + "/src/generated/java" +
//                        "]",
//                "--defaultpkg=org.platypus.erp.module.base",
//                "--moduleVersion=1",
//                "--depends=[]",
//                "--moduleQuickDesc=Sample Module with all platypus and community depends",
//                "--shortDesc=" + dir + "/src/main/resources/org.platypus.erp.module.base/short-desc.adoc",
//                "--longDesc=" + dir + "/src/main/resources/org.platypus.erp.module.base/long-desc.adoc"
//        );




        ReflectiveRootServiceParser reflectiveBusinessParser = new ReflectiveRootServiceParser(null);
        reflectiveBusinessParser.parse("base", Inherit0.class);
        reflectiveBusinessParser.parse("base", Inherit1.class);
    }
}
