package org.platypus.erp.security;

import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.Grant;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.query.RelationshipQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Path("login")
public class LoginRoute {

    private final Logger LOG = LoggerFactory.getLogger(LoginRoute.class);

    @Inject
    private Identity identity;

    @Inject
    private IdentityManager identityManager;

    @Inject
    private RelationshipManager relationshipManager;

    @Inject
    private DefaultLoginCredentials credentials;

    @GET
    @Path("avatar/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvatar(@NotNull @PathParam("email") String email) {
        return Response.ok().build();
    }

    @POST

    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@NotNull @Valid UserLoginPayload userLoginPayload) {
        Identity.AuthenticationResult result = Identity.AuthenticationResult.FAILED;
        if (!this.identity.isLoggedIn()) {
            this.credentials.setUserId(userLoginPayload.getUserid());
            this.credentials.setPassword(userLoginPayload.getPassword());
            result = this.identity.login();
            LOG.info("login payload userid={}, pwd={} with status={}", userLoginPayload.getUserid(), userLoginPayload.getPassword(), result);
        } else {
            LOG.info("user {} already logged in", userLoginPayload.getUserid());
        }
        return Response.ok(result).build();
    }



    @POST
    @Path("/authenticate")
    public Response authenticate(DefaultLoginCredentials credential) {
        if (!this.identity.isLoggedIn()) {
            this.credentials.setUserId(credential.getUserId());
            this.credentials.setPassword(credential.getPassword());
            this.identity.login();
        }

        if (this.identity.isLoggedIn()) {
            Account account = this.identity.getAccount();
            List<Role> roles = getUserRoles(account);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse(account, roles);

            return Response.ok().entity(authenticationResponse).type(MediaType.APPLICATION_JSON_TYPE).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credential").type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    private List<Role> getUserRoles(Account account) {
        RelationshipQuery<Grant> query = this.relationshipManager.createRelationshipQuery(Grant.class);

        query.setParameter(Grant.ASSIGNEE, account);

        List<Role> roles = new ArrayList<Role>();

        for (Grant grant: query.getResultList()) {
            roles.add(grant.getRole());
        }

        return roles;
    }

    private class AuthenticationResponse implements Serializable {

        private static final long serialVersionUID = 1297387771821869087L;

        private Account account;
        private List<Role> roles;

        public AuthenticationResponse(Account account, List<Role> roles) {
            this.account = account;
            this.roles = roles;
        }

        public Account getAccount() {
            return this.account;
        }

        public List<Role> getRoles() {
            return this.roles;
        }
    }
}
