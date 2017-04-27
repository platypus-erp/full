package org.platypus.erp.interceptor.logger;

import org.platypus.erp.conf.ErpConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LongRunningTask implements Callable<Void> {

	private static Logger LOGGER = LoggerFactory.getLogger(LongRunningTask.class);
	private final MethodInfos methodInfos;
	private final MethodInfosLogger methodInfosLogger;
    private boolean use = ErpConf.useLongRunnigTask();
    private Future<Void> future;
    private ExecutorService executor;
	
	public LongRunningTask(MethodInfos methodInfos) {
		this.methodInfos = methodInfos;
		methodInfosLogger = new MethodInfosLogger(LOGGER);
		methodInfosLogger.setUseTraceLog(false);
	}
	
	public void launch() {
		if (use) {
			executor = Executors.newSingleThreadExecutor();
			future = executor.submit(this);
		}
	}
	
	public void stop() {
		if (use) {
			future.cancel(true);
			executor.shutdownNow();
		}
	}

	@Override
    public Void call() throws Exception {
		int nbSleep = ErpConf.getDelayMilliSecond() / 100;
		for (int i = 0; i < nbSleep; i++) {
			Thread.sleep(100);
			if (Thread.interrupted()) {
				return null;
			}
		}
        methodInfos.getContextualLogInfo().init();
        methodInfos.setTime(ErpConf.getDelayMilliSecond());
        methodInfosLogger.logTrace(methodInfos);
        methodInfosLogger.logInfo(methodInfos);
        methodInfos.getContextualLogInfo().reset();
		return null;
    }
}
