package org.saurabh.restexample.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // This is defined to mark as a start point (root element) for JAX B to convert POJO to xml
public class Comment {
	
	private long id;
	private String comment;
	private Date created;
	private String author;
	
	public Comment() {
	}
	
	public Comment(long id, String message, String author) {
		super();
		this.id = id;
		this.comment = message;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		if (created == null) {
			created = new Date();
		}
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
