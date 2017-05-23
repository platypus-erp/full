package org.platypus.erp.core.business.manager;

import org.platypus.erp.core.business.entity.ResConfigInstaller;
import org.platypus.erp.manager.AbstractRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class ResConfigInstallerManager extends AbstractRepository<ResConfigInstaller> {

	public ResConfigInstallerManager() {
		super(ResConfigInstaller.class);
	}
}