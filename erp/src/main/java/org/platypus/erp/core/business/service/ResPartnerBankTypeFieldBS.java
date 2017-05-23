package org.platypus.erp.core.business.service;

import org.platypus.erp.core.business.entity.ResPartnerBankTypeField;
import org.platypus.erp.core.business.manager.ResPartnerBankTypeFieldManager;
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
@Path(CoreTableName.partnerBankTypeField)
@Stateless
public class ResPartnerBankTypeFieldBS extends AbstractRestService<ResPartnerBankTypeFieldManager, ResPartnerBankTypeField> {
}