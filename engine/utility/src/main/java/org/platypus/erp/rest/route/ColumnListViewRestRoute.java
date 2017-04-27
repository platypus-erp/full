package org.platypus.erp.rest.route;

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
@Path("/columns")
public class ColumnListViewRestRoute {

//    @Inject
//    ListViewColumnDelivrer delivrer;

    @GET
    @Path("{ressource}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubRoot(@PathParam("ressource") String ressource) {
        return Response.ok().build();
    }
}
