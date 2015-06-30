package nl.han.ddoa.forumplugin.services.rest;

import nl.han.ddoa.forumplugin.entities.ForumThreadRepository;

import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Description for the class ForumThreadRestService:
 * <p/>
 * Provides a REST API to the ActiveObjects-layer using JAX-RS. We need JSON/XML Serializable entities, so
 * all data is converted from/to AO <-> JSON/XML.
 * <p/>
 *
 * @author mdkr
 * @version Copyright (c) 2014 HAN University, All rights reserved.
 */
@Path("/")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ForumThreadRestService {

    private ForumThreadRepository forumThreadRepository;

    public ForumThreadRestService(ForumThreadRepository forumThreadRepository) {
        this.forumThreadRepository = forumThreadRepository;
    }

    @GET
    @Path("threads")
    public Response allThreads() {
        return Response.ok(SerializableForumThread.build(forumThreadRepository.all())).build();
    }

    @POST
    @Path("threads")
    public Response saveThread(@WebParam String title) {
        return Response.ok(SerializableForumThread.build(forumThreadRepository.add(title))).build();
    }

    @DELETE
    @Path("threads/{id}")
    public Response deleteThread(@PathParam("id") int id) {
        forumThreadRepository.delete(id);
        return Response.ok().build();
    }

}
