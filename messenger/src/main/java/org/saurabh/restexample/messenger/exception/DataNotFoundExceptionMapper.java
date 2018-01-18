package org.saurabh.restexample.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.saurabh.restexample.messenger.model.ErrorMessage;

@Provider // This tells the JAX - RS that we have an intercepting exception handling mechanism for DataNotFoundException
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// return Response.status(Status.NOT_FOUND).build();
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "www.google.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
