package org.saurabh.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test") // We can also map variable in our resource path and consume them and store in member variables
//@Singleton // Cannot make this singleton as they are created before request comes in
public class MyParamMemeberResource {
	
	@PathParam("pathParam") 
	private String myPathParam;
	
	@QueryParam("query")
	private String myQueryParam;
	
	// Applicable to all Param types like Matrix, Bean, Header, Cookie, Form

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		// TO TEST USE
		// http://localhost:8080/advanced-jaxrs-01/saurabh/Hello/test?query=Test
		
		return "Hurray !! My Path Param - " + myPathParam + " : My Query Param - " + myQueryParam;
	}
}
