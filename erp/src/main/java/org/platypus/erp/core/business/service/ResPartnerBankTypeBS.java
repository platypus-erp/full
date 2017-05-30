package org.platypus.erp.core.business.service;

import org.platypus.erp.core.business.entity.ResPartnerBankType;
import org.platypus.erp.core.business.manager.ResPartnerBankTypeManager;
import org.platypus.erp.core.util.CoreTableName;
import org.platypus.api.service.PlatypusService;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 03/08/16.
 *
 * @version 0.1
 * @since 0.1
 */
@Path(CoreTableName.partnerBankType)
@Stateless
public class ResPartnerBankTypeBS extends PlatypusService<ResPartnerBankTypeManager, ResPartnerBankType> {
}