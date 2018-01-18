package org.saurabh.restexample.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotation")
	public String injectDemo(@MatrixParam("param") String matrixParam, 
							 @HeaderParam("customHeader") String headerParam, // For passing session info
							 @CookieParam("JSESSIONID") String cookieParam) { 
		return "Matrix Param -> " + matrixParam + " : Header Param -> " + headerParam + " : Cookie Param -> " + cookieParam;
	}
	
	@GET
	@Path("context")
	/*
	 * @Context is used in case we are not sure what params we will receive in our URL
	 * or what Header values to expect as Header param
	 */
	public String contextDemo(@Context UriInfo uriInfo, @Context HttpHeaders header) {
		String url = uriInfo.getAbsolutePath().toString();
		String cookie = header.getCookies().toString();
		return "URL -> " + url + " | Cookie -> " + cookie;
	}
}
