package com.sightseekerstudio.wildflyswarmmpdemo.ping;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/ping")
@Tag(name = "PING")
@Extension(name = "x-tagGroups", value = "GENERAL")
public class PingResource {

    @GET
    @Produces("text/plain")
    @Operation(summary = "ping", description = "疎通確認用リソース")
    public Response doGet() {
        return Response.ok("pong").build();
    }
}
