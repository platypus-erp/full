package org.platypus.erp.core.business.manager;

import org.platypus.erp.core.business.entity.ResCurrencyRate;
import org.platypus.erp.manager.AbstractRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class ResCurrencyRateManager extends AbstractRepository<ResCurrencyRate> {

	public ResCurrencyRateManager() {
		super(ResCurrencyRate.class);
	}
}