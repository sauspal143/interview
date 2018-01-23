package org.saurabh.demo.hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


// @Entity -> Will create a table with Entity name -> userdetails
// @Entity (name="USER_DETAILS") // Use name attribute of Entity annotation for having specific names for your entity
@Entity // Represents entity name userdetails which will be used in hql
@Table (name="USER_DETAILS") // Represents physical table name in db 
public class UserDetails {
	
	@Id
	@Column (name="USER_ID") // @Column provides handle to create specific Column names in the table
	private int userId; // Natural key as it has business significance. If it is not business significant than surrogate key
	@Column (name="USER_NAME")
    private String userName;
	//@Basic (fetch=FetchType.LAZY) // By default it uses @Basic if not specified but we can use to specify fetch type and optional attribute
	private String address;
	@Transient // If we do not want hobbies to be stored in DB than mark it transient. It gets ignored.
	private String hobbies;
	@Temporal(TemporalType.DATE) // To just save date use TemporalType.DATE for time TemporalType.TIME, DEFAULT is TIMESTAMP
	private Date joinedDate;
	@Lob // If column is of type String it would be considered as CLOB else BLOB
	private String description;
    
    public UserDetails() {
    }
    
	public UserDetails(int userId, String userName, String address, String hobbies) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.hobbies = hobbies;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	// @Column (name="USER_NAME") // You can have the annotation on top of the getter also
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
