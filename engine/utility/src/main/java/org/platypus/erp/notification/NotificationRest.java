package org.platypus.erp.notification;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
@Path(Notification.TABLE)
@Stateless
public class NotificationRest {

    @Inject NotificationRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewNotification(){
        return Response.ok(repository.getUnSeenNotification()).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response markAsRead(@PathParam("id") int id){
        repository.markAsRead(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response markAllAsRead(){
        repository.markAllAsRead();
        return Response.ok().build();
    }
}
