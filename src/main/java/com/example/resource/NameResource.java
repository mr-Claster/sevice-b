package com.example.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/name")
public class NameResource {

    private static final Logger LOG = Logger.getLogger(NameResource.class);

    public record NameResponse(String name) {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public NameResponse getName(@HeaderParam("X-Correlation-ID") String correlationId) {
        LOG.infof("GET /name | correlationId=%s", correlationId);
        return new NameResponse("Олена");
    }
}