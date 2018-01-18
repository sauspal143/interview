package org.saurabh.restexample.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
// import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.saurabh.restexample.messenger.database.DatabaseClass;
import org.saurabh.restexample.messenger.model.Comment;
import org.saurabh.restexample.messenger.model.ErrorMessage;
import org.saurabh.restexample.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getCommentsForMessage(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments != null ? new ArrayList<Comment>(comments.values()) : new ArrayList<Comment>();
	}
	
	public Comment getCommentForMessage(long messageId, long commentId) {
		// Not ideal to have such implementations as Business logic does not have to worry anything about error handling and rendering logic for client level
		ErrorMessage errorMessage = new ErrorMessage("Message Id - " + messageId + " not found in table messages", 404, "www.google.com");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		Message message = messages.get(messageId);
		if (message == null) {
			// throw new WebApplicationException(response);
			throw new NotFoundException(response); // Could have specific out of the box Exceptions provided by Jax RS which extends from WebApplicationException
		}
		
		Map<Long, Comment> comments = message.getComments();
		return comments != null ? comments.get(commentId) : new Comment();
	}
	
	public Comment addCommentForMessage(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment deleteCommentForMessage(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
	public Comment updateCommentForMessage(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public List<Comment> getCommentsForMessageSaurabh(long messageId) {
		List<Comment> comments = new ArrayList<Comment>();
		for (Message message : messages.values()) {
			if (message.getId() == messageId && message.getComments() != null) {
				comments.addAll(message.getComments().values());
				break;
			}
		}
		
		return comments;
	}
	
	public Comment getCommentForMessageSaurabh(long messageId, long commentId) {
		Comment comment = new Comment();
		for (Message message : messages.values()) {
			if (message.getId() == messageId && message.getComments() != null) {
				for (Comment com : message.getComments().values()) {
					if (com.getId() == commentId) {
						comment = com;
						break;
					}
				}
			}
		}
		
		return comment;
	}
	
	public Comment addCommentForMessageSaurabh(long messageId, Comment comment) {
		for (Message message : messages.values()) {
			if (message.getId() == messageId && message.getComments() != null) {
				comment.setId(message.getComments().size() + 1);
				Map<Long, Comment> comments = message.getComments();
				comments.put(comment.getId(), comment);
				break;
			}
		}
		
		return comment;
	}
	
	public Comment deleteCommentForMessageSaurabh(long messageId, long commentId) {
		Comment comment = new Comment();
		for (Message message : messages.values()) {
			if (message.getId() == messageId && message.getComments() != null) {
				Map<Long, Comment> comments = message.getComments();
				comment = comments.get(commentId);
				comments.remove(commentId);
				break;
			}
		}
		
		return comment;
	}
	
	public Comment updateCommentForMessageSaurabh(long messageId, Comment comment) {
		for (Message message : messages.values()) {
			if (message.getId() == messageId && message.getComments() != null) {
				Map<Long, Comment> comments = message.getComments();
				comments.put(comment.getId(), comment);
				break;
			}
		}
		
		return comment;
	}
}
