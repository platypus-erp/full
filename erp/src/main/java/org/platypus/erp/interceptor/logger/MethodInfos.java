package org.platypus.erp.interceptor.logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MethodInfos implements Serializable {

	private static final long serialVersionUID = 5226097353347097759L;
	private static final AtomicLong uniqueIdSequence = new AtomicLong();

	private ContextualLogInfo contextualLogInfo;
	private String method;
	private List<Object> parameters = new ArrayList<>();
	private Object returnObject;
	private String threadName;
	private long time;
	private long uniqueId;

	public MethodInfos() {
		uniqueId = uniqueIdSequence.incrementAndGet();
	}
	
	public ContextualLogInfo getContextualLogInfo() {
		return contextualLogInfo;
	}

    public void setContextualLogInfo(ContextualLogInfo contextualLogInfo) {
        this.contextualLogInfo = contextualLogInfo;
    }

    public String getMethod() {
		return method;
	}

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Object> getParameters() {
		return parameters;
	}

    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    public Object getReturnObject() {
		return returnObject;
	}

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public long getTime() {
		return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getUniqueId() {
		return uniqueId;
	}
	
	public String getThreadName() {
		return threadName;
	}
	
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
}
