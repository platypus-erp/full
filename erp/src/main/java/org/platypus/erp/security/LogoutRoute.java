package org.platypus.erp.security;

import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Path("logout")
public class LogoutRoute {

    private final Logger LOG = LoggerFactory.getLogger(LogoutRoute.class);

    @Inject
    private Identity identity;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        Identity.AuthenticationResult result = Identity.AuthenticationResult.FAILED;
        if (!this.identity.isLoggedIn()) {
            result = Identity.AuthenticationResult.SUCCESS;
        } else {
            this.identity.logout();
            result = Identity.AuthenticationResult.SUCCESS;
            LOG.info("logout OK");
        }
        return Response.ok(result).build();
    }
}