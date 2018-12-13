package com.sightseekerstudio.wildflyswarmmpdemo.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/ping")
@Tag(name = "PING")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "ping", description = "疎通確認用")
    public Response doGet() {
        return Response.ok("pong").build();
    }
}
