package org.platypus.builder;

import org.platypus.api.annotations.Service;
import org.platypus.builder.core.MainArgs;
import org.platypus.builder.core.records.manager.ModelsFinder;
import org.platypus.builder.core.records.manager.QuickRecordGenerator;
import org.platypus.builder.core.service.ServiceFinder;

/**
 * @author chmuchme
 * @since 0.1
 * on 24/04/17.
 */
public class QuickServiceBuilder {
    public static void main(String[] args) throws Exception {
        MainArgs mainArgs = new MainArgs(args);
        run(mainArgs);
    }

    public static void run(MainArgs mainArgs) throws Exception {
        new QuickRecordGenerator(mainArgs.projectDirGenerated, mainArgs.defaultPkg, mainArgs.modulename,
                )
                .generateRecord();
    }
}
