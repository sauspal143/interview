package org.saurabh.restexample.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.saurabh.restexample.messenger.model.Comment;
import org.saurabh.restexample.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getCommentsForMessage(@PathParam("messageId") int messageId) {
		return commentService.getCommentsForMessage(messageId);
	}
	
	@GET
	@Path("{commentId}")
	public Comment getCommentForMessage(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
		return commentService.getCommentForMessage(messageId, commentId);
	}
	
	@POST
	public Comment addCommentForMessage(@PathParam("messageId") int messageId, Comment comment) {
		return commentService.addCommentForMessage(messageId, comment);
	}
	
	@PUT
	@Path("{commentId}")
	public Comment updateCommentForMessage(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateCommentForMessage(messageId, comment);
	}
	
	@DELETE
	@Path("{commentId}")
	public void deleteCommentForMessage(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {
		commentService.deleteCommentForMessage(messageId, commentId);
	}
}
