package org.platypus.erp.core.business.service;

import org.platypus.erp.core.business.entity.ResPartnerBank;
import org.platypus.erp.core.business.manager.ResPartnerBankManager;
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
@Path(CoreTableName.partnerBank)
@Stateless
public class ResPartnerBankBS extends PlatypusService<ResPartnerBankManager, ResPartnerBank> {
}