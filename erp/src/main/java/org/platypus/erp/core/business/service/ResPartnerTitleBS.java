package org.platypus.erp.core.business.service;

import org.platypus.erp.core.business.entity.ResPartnerTitle;
import org.platypus.erp.core.business.manager.ResPartnerTitleManager;
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
@Path(CoreTableName.partnerTitle)
@Stateless
public class ResPartnerTitleBS extends AbstractRestService<ResPartnerTitleManager, ResPartnerTitle> {
}