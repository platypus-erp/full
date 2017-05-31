package org.platypus.builder;

import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.records.manager.ModelsFinder;
import org.platypus.builder.core.records.manager.QuickRecordGenerator;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class QuickRecordBuilder {
    public static void main(String[] args) throws Exception {
        MainArgs mainArgs = new MainArgs(args);
        run(mainArgs);
    }

    public static void run(MainArgs mainArgs) throws Exception {
        new QuickRecordGenerator(mainArgs.projectDirGenerated, mainArgs.defaultPkg, mainArgs.modulename,
                ModelsFinder.run(mainArgs.modelsDir))
                .generateRecord();
    }
}
