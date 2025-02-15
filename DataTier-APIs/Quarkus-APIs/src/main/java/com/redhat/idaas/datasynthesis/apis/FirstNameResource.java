package com.redhat.idaas.datasynthesis.apis;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.redhat.idaas.datasynthesis.dtos.NameFirst;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.services.NameFirstService;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/first-names")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FirstNameResource {
    @Inject
    NameFirstService service;

    @GET
    public List<NameFirst> getFirstNames(
        @Parameter(description = "number of random records to be retrieved") @QueryParam int count) {
            return service.retrieveRandomData(count);
    }
    
    @POST
    @APIResponse(responseCode = "201")
    public Response generateFirstNames(NameFirst nameObj) throws DataSynthesisException {
        service.insertNameFirst(nameObj.firstName, nameObj.gender);
        return Response.status(Status.CREATED).build();
    }
}
