package org.platypus.erp.core.business.service;

import org.platypus.erp.core.business.entity.ResConfigInstaller;
import org.platypus.erp.core.business.manager.ResConfigInstallerManager;
import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.service.AbstractRestService;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 03/08/16.
 *
 * @version 0.1
 * @since 0.1
 */
@Path(CoreTableName.configInstaller)
@Stateless
public class ResConfigInstallerBS extends AbstractRestService<ResConfigInstallerManager, ResConfigInstaller> {

}