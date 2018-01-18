package org.saurabh.restexample.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.saurabh.restexample.messenger.model.Link;
import org.saurabh.restexample.messenger.model.Message;
import org.saurabh.restexample.messenger.resources.beans.MessageFilterBean;
import org.saurabh.restexample.messenger.service.MessageService;

@Path("/messages") // One can also use regular expression for catching similar urls e.g starting with message*
//If your methods do both can apply to class level instead of applying to individual level.
@Consumes(MediaType.APPLICATION_JSON)
// For content negotiation we can map multiple media type with value attribute
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML}) 
public class MessageResource {
	
	MessageService messageService = new MessageService();

	/*@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessagesPlain() {
		return "Hello World !!!";
	}*/
	
	/*@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addMessagePlain() {
		return "Add works with POST !!!";
	}*/
	
	@POST // For POST method we need to provide @Consumes annotation to specify the expected body format
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT // For updates
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}") 
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}") 
	// @Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessages(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}") // {} tells that param is variable
	// @Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) { // Path Param name and Path should map, method param name can be anything
		Message message = messageService.getMessage(id);
		if (message == null) {
			throw new NotFoundException("Not able to find any message information for message Id - " + id); // Decent place to have WebApplicationException based exception handling
		}
		message.getLinks().add(getLink("self", uriInfo, message));
		message.getLinks().add(getLink("profile", uriInfo, message));
		message.getLinks().add(getLink("comments", uriInfo, message));
		return messageService.getMessage(id);
	}
	
	private Link getLink(String rel, UriInfo uriInfo, Message message) {
		// String url = uriInfo.getBaseUriBuilder().path(MessageResource.class).path("getMessage").resolveTemplate("messageId", messageId).toString();
		String url = "";
		
		if(rel.equalsIgnoreCase("self")) {
			url = uriInfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(message.getId()+"")
					.toString();
		} else if (rel.equalsIgnoreCase("profile")) {
			url = uriInfo.getBaseUriBuilder()
					.path(ProfileResource.class)
					.path(message.getAuthor()+"")
					.toString();
		} else if (rel.equalsIgnoreCase("comments")) {
			url = uriInfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(MessageResource.class, "getCommentResource")
					.resolveTemplate("messageId", message.getId()+"")
					.toString();
		}
		
		Link link = new Link(url, rel);
		return link;
	}

	@GET
	//@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	// public List<Message> getMessages(@QueryParam("year") int yearPassed, @QueryParam("start") int start, @QueryParam("size") int pageSize) {
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("application xml called ...");
		if (filterBean.getYearPassed() > 0) {
			return messageService.getMessagesForYear(filterBean.getYearPassed());
		} else if (filterBean.getStart() >= 0 && filterBean.getPageSize() > 0) {
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getPageSize());
		}
		return messageService.getAllMessages();
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON) // These method level acts as override when class level declarations are also present
	public List<Message> getJSONMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("JSON called ...");
		if (filterBean.getYearPassed() > 0) {
			return messageService.getMessagesForYear(filterBean.getYearPassed());
		} else if (filterBean.getStart() >= 0 && filterBean.getPageSize() > 0) {
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getPageSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXMLMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Text xml called ...");
		if (filterBean.getYearPassed() > 0) {
			return messageService.getMessagesForYear(filterBean.getYearPassed());
		} else if (filterBean.getStart() >= 0 && filterBean.getPageSize() > 0) {
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getPageSize());
		}
		return messageService.getAllMessages();
	}*/
	
	// Many to One mapping type of URLs can be mapped as sub-resource
	// For example our case of /messages/{messageId}/comments
	// Here the Parent resource MessageResource can have a method returning the Child Resource CommentResource
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
