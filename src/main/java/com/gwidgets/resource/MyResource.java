package com.gwidgets.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwidgets.service.SimpleService;


@Path("/resource")
public class MyResource {
	
	@Inject
	SimpleService simpleService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return simpleService.getMessage();
    }
}