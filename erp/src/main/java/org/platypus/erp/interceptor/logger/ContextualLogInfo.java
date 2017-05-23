package org.platypus.erp.interceptor.logger;

import org.slf4j.MDC;

public class ContextualLogInfo {

	private final String user;
	private final String tenant;

	public ContextualLogInfo(String user, String tenant) {
		this.user = user;
		this.tenant = tenant;
        init();
	}
	
	public void init() {
        MDC.put("user", user);
        if (tenant == null) {
            MDC.remove("tenant");
        } else {
            MDC.put("tenant", tenant);
        }
	}
	
	public void reset() {
		MDC.remove("user");
		MDC.remove("tenant");
	}

}
