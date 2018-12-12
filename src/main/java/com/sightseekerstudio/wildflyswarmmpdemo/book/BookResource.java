package com.sightseekerstudio.wildflyswarmmpdemo.book;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sightseekerstudio.wildflyswarmmpdemo.jaxrs.ext.ConstraintViolationExceptionMapper.ConstraintViolationExceptionModel;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/book")
@Tag(name = "BOOK")
public class BookResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "本の情報を取得する")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Book.class)))
    public Book find(@PathParam("id") int id) {
        return new Book(0, "Java本格入門 ~モダンスタイルによる基礎からオブジェクト指向・実用ライブラリまで", 3218);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "本の情報を保存する")
    @APIResponse(responseCode = "201", description = "Success")
    @APIResponse(responseCode = "400", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ConstraintViolationExceptionModel.class)))
    public void save(@RequestBody @Valid Book book) {

    }

}
