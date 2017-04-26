package org.platypus.records.main;


import org.platypus.builder.QuickRecordBuilder;

/**
 * @author chmuchme
 * @since 0.1
 * on 22/04/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String projectDir = "/home/apasquier/WorkSpace/Java/full/module/base";
        String group = "org.platypus.erp";
        String name = "base";
        QuickRecordBuilder.run(projectDir, group, name);
    }
}
