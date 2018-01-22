package org.saurabh.demo.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAILS") // Use name attribute of Entity annotation for having specific names for your entity
// @Entity -> Will create a table with Entity name -> userdetails
public class UserDetails {
	
	@Id
	@Column (name="USER_ID") // @Column provides handle to create specific Column names in the table
	private int userId;
	
    private String userName;
    
    public UserDetails() {
    }
    
	public UserDetails(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="USER_NAME") // You can have the annotation on top of the getter also
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
