package org.platypus.erp.rest.route;

import org.platypus.erp.cdi.spi.front.menu.MenuDelivrer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
@Path("/menu")
public class MenuRestRoute {

    @Inject
    private MenuDelivrer delivrer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMenuRoot() {
        return Response.ok().entity(delivrer.getRoots()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubRoot(@PathParam("id") String id) {
        return Response.ok().entity(delivrer.getSubRoots(id)).build();
    }
}
