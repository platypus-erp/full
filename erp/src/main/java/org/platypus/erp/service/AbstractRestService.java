package org.platypus.erp.service;

import org.platypus.erp.entity.AbstractEntity;
import org.platypus.erp.entity.event.create.AfterCreateLiteral;
import org.platypus.erp.entity.event.create.BeforeCreateLiteral;
import org.platypus.erp.entity.event.delete.AfterDeleteLiteral;
import org.platypus.erp.entity.event.delete.BeforeDeleteLiteral;
import org.platypus.erp.entity.event.select.id.AfterSelectByIdLiteral;
import org.platypus.erp.entity.event.select.id.BeforeSelectByIdLiteral;
import org.platypus.erp.entity.event.select.list.AfterSelectListLiteral;
import org.platypus.erp.entity.event.select.list.BeforeSelectListLiteral;
import org.platypus.erp.entity.event.update.AfterUpdateLiteral;
import org.platypus.erp.entity.event.update.BeforeUpdateLiteral;
import org.platypus.erp.exceptions.CunstructorTotoErpException;
import org.platypus.erp.manager.AbstractRepository;
import org.platypus.erp.rest.ConstraintViolationEntity;
import org.platypus.erp.rest.filter.ListFilter;
import org.platypus.erp.rest.payload.ListPayload;
import org.platypus.erp.rest.payload.PayLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public abstract class AbstractRestService<M extends AbstractRepository<E>, E extends AbstractEntity> extends AbstractRestEventService<M, E> {

    private final Logger LOG = LoggerFactory.getLogger(AbstractRestService.class);
    @Inject
    Event<PayLoad> eventPayLoad;

    @Inject
    Event<List<E>> eventGETList;

    @Inject
    Event<Long> eventDelete;


    /**
     * This cunstructor can't be called
     *
     * @throws CunstructorTotoErpException
     */
    protected AbstractRestService() {
        throw new CunstructorTotoErpException();
    }

    protected AbstractRestService(Class<E> clazz) {
        super(clazz);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRest(@NotNull @Valid PayLoad payLoad) {
        Response.ResponseBuilder responseBuilder;
        try {
            eventPayLoad.select(new BeforeCreateLiteral(clazz)).fire(payLoad);
            E entity = payLoad.getEntity();
            super.insert(entity);
            payLoad.setEntity(entity);
            eventPayLoad.select(new AfterCreateLiteral(clazz)).fire(payLoad);
            responseBuilder = Response.ok(payLoad);
        } catch (ConstraintViolationException violation) {
            responseBuilder = constraintEror(violation);
        } catch (Exception e) {
            responseBuilder = error(e);
        }
        return responseBuilder.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRest(@NotNull @Valid PayLoad payLoad) {
        Response.ResponseBuilder responseBuilder;
        try {
            eventPayLoad.select(new BeforeUpdateLiteral()).fire(payLoad);
            super.update(payLoad.getEntity());
            eventPayLoad.select(new AfterUpdateLiteral()).fire(payLoad);
            responseBuilder = Response.ok();
        } catch (ConstraintViolationException violation) {
            responseBuilder = constraintEror(violation);
        } catch (Exception e) {
            responseBuilder = error(e);
        }
        return responseBuilder.build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRest(@PathParam("id") long id) {
        Response.ResponseBuilder responseBuilder;
        try {
            eventDelete.select(new BeforeDeleteLiteral(clazz)).fire(id);
            super.delete(id);
            eventDelete.select(new AfterDeleteLiteral(clazz)).fire(id);
            responseBuilder = Response.ok();
        } catch (Exception e) {
            responseBuilder = error(e);
        }
        return responseBuilder.build();

    }

    @GET
    @NotNull
    @Produces(MediaType.APPLICATION_JSON)
    public Response listRest(
            @QueryParam("filterId") String filterId,
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Integer pageSize) {
        LOG.info("filters {}", filterId);
        LOG.info("page {}", page);
        LOG.info("pageSize {}", pageSize);
        ListFilter listFilter = new ListFilter(page, pageSize, filterId);


        Response.ResponseBuilder responseBuilder;
        try {
            ListPayload<E> payload = new ListPayload<>(super.count(listFilter.getFilterId()));
            List<E> list = new ArrayList<>();
            eventGETList.select(new BeforeSelectListLiteral(clazz)).fire(unmodifiableList(list));
            list.addAll(super.getList(listFilter));
            eventGETList.select(new AfterSelectListLiteral(clazz)).fire(unmodifiableList(list));
            payload.setDatas(list);
            responseBuilder = Response.ok(payload);
        } catch (Exception e) {
            responseBuilder = error(e);
        }
        return responseBuilder.build();
    }

    @GET
    @Path("{id}")
    @NotNull
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIdRest(@PathParam("id") long id) {
        Response.ResponseBuilder responseBuilder;
        try {
            PayLoad payLoad = new PayLoad(id);
            eventPayLoad.select(new BeforeSelectByIdLiteral(clazz)).fire(payLoad);
            E e = super.getById(id);
            payLoad.setEntity(e);
            eventPayLoad.select(new AfterSelectByIdLiteral(clazz)).fire(payLoad);
            responseBuilder = Response.ok(payLoad);
        } catch (Exception e) {
            responseBuilder = error(e);
        }
        return responseBuilder.build();
    }

    private Response.ResponseBuilder error(Exception e) {
        LOG.error("ERROR FOR CLASS[" + clazz.getName() + "]", e);
        return Response.serverError().entity(e.getLocalizedMessage());
    }

    private Response.ResponseBuilder constraintEror(ConstraintViolationException violation) {
        LOG.error("VIOLATION CONSTRAINT FOR CLASS[" + clazz.getName() + "]", violation);
        return Response.serverError().entity(new ConstraintViolationEntity(violation.getConstraintViolations()));
    }
}
