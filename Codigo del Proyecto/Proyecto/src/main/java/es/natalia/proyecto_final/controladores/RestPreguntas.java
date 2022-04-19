package es.natalia.proyecto_final.controladores;


import es.natalia.proyecto_final.entidades.Pregunta;
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
@Path("/api/pregunta")
public class RestPreguntas {

    @Inject
    NivelService nivelService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") @NotNull Long id) {
        Optional<Pregunta> pregunta = nivelService.buscarPorIdPreguntaOp(id);

        return pregunta.map(value -> Response.ok(value).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Pregunta pregunta) {
        try {
            Long id = nivelService.guardar(pregunta).getId();
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
    public Response update(@Valid Pregunta pregunta, @PathParam("id") @NotNull Long id) {
        try {
            Optional<Pregunta> preg = nivelService.buscarPorIdPreguntaOp(id);
            if (preg.isPresent()) {
                nivelService.guardar(pregunta);
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
            Optional<Pregunta> pregunta = nivelService.buscarPorIdPreguntaOp(id);
            if (pregunta.isPresent()) {
                nivelService.borrar(pregunta.get());
                return Response.ok().build();
            } else
                return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Response.notModified().build();
        }
    }

}
