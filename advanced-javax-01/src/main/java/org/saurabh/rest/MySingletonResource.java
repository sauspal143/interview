package org.saurabh.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testSingleton")
@Singleton // This ensures that resource (scope of resource is request based) state is maintained across requests
public class MySingletonResource {
	
	private int count;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testSingleMethod() {
		count = count + 1;
		return "testSingleMethod() was called [" + count + "] times";
	}
}
