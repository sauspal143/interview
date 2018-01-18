package org.saurabh.restexample.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;

import org.saurabh.restexample.messenger.model.ErrorMessage;

//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ErrorMessage("Some Server side exception occured while processing your request", 500, "www.google.com"))
				.build();
	}

}
