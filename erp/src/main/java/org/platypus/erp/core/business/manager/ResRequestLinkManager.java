package org.platypus.erp.core.business.manager;

import org.platypus.erp.core.business.entity.ResRequestLink;
import org.platypus.erp.manager.AbstractPlatypusRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class ResRequestLinkManager extends AbstractPlatypusRepository<ResRequestLink> {

	public ResRequestLinkManager() {
		super(ResRequestLink.class);
	}
}