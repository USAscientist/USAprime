package com.pinewaterneck.rest;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;


import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class MasterConfigurator extends ResourceConfig {

	public MasterConfigurator() {
		super();
	}
	public MasterConfigurator(@Context ServletContext context ) {
		super();
		System.out.println("MasterConfigurator -----------  Constrctor 2");
		this.packages("com.pinewater.rest");
		this.register(PineWater.class);
	}
}
