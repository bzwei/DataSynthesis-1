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

import com.redhat.idaas.datasynthesis.dtos.Count;
import com.redhat.idaas.datasynthesis.dtos.EIN;
import com.redhat.idaas.datasynthesis.exception.DataSynthesisException;
import com.redhat.idaas.datasynthesis.services.EINService;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/employer-identification-numbers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EINResource {
    @Inject
    EINService einService;

    @GET
    public List<EIN> getEINs(
        @Parameter(description = "number of random records to be retrieved") @QueryParam int count) {
            return einService.retrieveRandomData(count);
    }
    
    @POST
    @APIResponse(responseCode = "201")
    public Response generateEINs(Count countBody) throws DataSynthesisException {
        einService.generateEinNumber(countBody.count);
        return Response.status(Status.CREATED).build();
    }
}
