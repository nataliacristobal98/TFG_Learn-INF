package es.natalia.proyecto_final.controladores;

import es.natalia.proyecto_final.entidades.Test;
import es.natalia.proyecto_final.servicios.NivelService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Path("/api/test")
public class RestTest {

    @Inject
    NivelService nivelService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") @NotNull Long id) {
        Optional<Test> test = nivelService.buscarPorIdTestOp(id);

        return test.map(value -> Response.ok(value).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Test test) {
        try {
            Long id = nivelService.guardar(test).getId();
            return Response.ok(Collections.singletonMap("id", id)).status(Response.Status.CREATED).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Response.notModified().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid Test test, @PathParam("id") @NotNull Long id) {
        try {
            Optional<Test> test2 = nivelService.buscarPorIdTestOp(id);
            if (test2.isPresent()) {
                nivelService.guardar(test);
                return Response.ok().build();
            } else
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") @NotNull Long id) {
        try {
            Optional<Test> test = nivelService.buscarPorIdTestOp(id);
            if (test.isPresent()) {
                nivelService.borrar(test.get());
                return Response.ok().build();
            } else
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Response.notModified().build();
        }
    }

}

