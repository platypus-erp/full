package org.platypus.erp.core.business.manager;

import org.platypus.erp.core.business.entity.ResConfigSetting;
import org.platypus.erp.manager.AbstractPlatypusRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class ResConfigSettingManager extends AbstractPlatypusRepository<ResConfigSetting> {

	public ResConfigSettingManager() {
		super(ResConfigSetting.class);
	}
}