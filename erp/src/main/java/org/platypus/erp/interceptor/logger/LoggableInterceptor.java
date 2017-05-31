package org.platypus.erp.interceptor.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import java.lang.reflect.Method;
import java.util.Arrays;


@Interceptor
@Loggable
public class LoggableInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggableInterceptor.class);
    private final static MethodInfosLogger methodInfosLogger = new MethodInfosLogger(LOGGER);

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        long beginTime = System.currentTimeMillis();
        boolean isException = false;
        Object returnObject;
        ContextualLogInfo contextualLogInfo = new ContextualLogInfo("TOTO_USER", null);
        MethodInfos methodInfos = createTimerInfo(ic, contextualLogInfo);
        LongRunningTask longRunningTask = new LongRunningTask(methodInfos);
        longRunningTask.launch();
        try {
            returnObject = ic.proceed();
            methodInfos.setReturnObject(returnObject);
            return returnObject;
        } catch (Exception e) {
            isException = true;
            throw e;
        } finally {
            longRunningTask.stop();
            methodInfos.setTime(System.currentTimeMillis() - beginTime);
            log(methodInfos, isException);
        }
    }

    private void log(MethodInfos methodInfos, boolean isException) {
        methodInfosLogger.logInfo(methodInfos);
        if (isException) {
            methodInfosLogger.setUseTraceLog(false);
            methodInfosLogger.logTrace(methodInfos);
        } else if (LOGGER.isTraceEnabled()) {
            methodInfosLogger.setUseTraceLog(true);
            methodInfosLogger.logTrace(methodInfos);
        }
    }

    private MethodInfos createTimerInfo(InvocationContext ic, ContextualLogInfo contextualLogInfo) {
        Method method = ic.getMethod();
        MethodInfos methodInfos = new MethodInfos();
        methodInfos.setContextualLogInfo(contextualLogInfo);
        methodInfos.setMethod(method.getDeclaringClass().getSimpleName() + "." + method.getName());
        methodInfos.setParameters(Arrays.asList(ic.getParameters()));
        methodInfos.setThreadName(Thread.currentThread().getName());
        return methodInfos;
    }
}
