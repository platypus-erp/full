package org.platypus.erp.core.partner;

import org.platypus.erp.manager.AbstractRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class PartnerRepository extends AbstractRepository<Partner> {

	public PartnerRepository() {
		super(Partner.class);
	}
}