package com.pinewaterneck.rest;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("pinewater")
public class PineWater implements PineWaterIfc {
	@Context ServletContext context;
	@Context HttpServletResponse servletResponse;
	@Context HttpServletRequest servletRequest;
	
	@GET
	@Produces( MediaType.TEXT_HTML )
	@Path("{unkown}")
	public Response getApples( @PathParam("unkown") String name) {
		//Response response=null;
		ResponseBuilder responseBuilder=null;
		//StringBuilder sb = new StringBuilder();
		DomBuilder dom = new DomBuilder();
		System.out.println("PineWater ------------------------ PICKING apples");
		System.out.println("PineWater ------------------------ PICKING PATHPARAM"+ name);
		System.out.println("PineWater ------------------------ PICKING CTX:"+context.getContextPath());
		System.out.println("PineWater ------------------------ PICKING sr CTX:"+servletRequest.getPathInfo());
		System.out.println("PineWater ------------------------ PICKING sr CTX LOCAL:"+servletRequest.getLocalAddr());
		System.out.println("PineWater ------------------------ PICKING sr CTX LOCAL:"+servletRequest.getProtocol());
		System.out.println("PineWater ------------------------ PICKING sr CTX LOCAL:"+servletRequest.getRequestURL().toString());
		try {
			servletRequest.authenticate(servletResponse);
			
		    
		     responseBuilder=Response.ok().status(200);
		     responseBuilder.entity(dom.getDom());
		     
		     
			System.out.println("PineWater ------------------------AUTHING");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//servletResponse.sendRedirect("http://www.yahoo.com");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseBuilder.build();
		
	}
}
