package org.platypus.erp.core.partner;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.interceptor.logger.Loggable;
import org.platypus.api.service.PlatypusService;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 03/08/16.
 *
 * @version 0.1
 * @since 0.1
 */
@Path(CoreTableName.partner)
@Stateless
@Loggable
public class PartnerBS extends PlatypusService<PartnerRepository, Partner> {

    public PartnerBS() {
        super(Partner.class);
    }
}