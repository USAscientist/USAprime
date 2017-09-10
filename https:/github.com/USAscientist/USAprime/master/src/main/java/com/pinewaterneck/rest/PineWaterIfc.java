package com.pinewaterneck.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("micky")
public interface PineWaterIfc {

		@GET
		@Produces( MediaType.APPLICATION_XHTML_XML )
		public Response getApples( @PathParam("unkown") String name);
}
