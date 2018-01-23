package org.saurabh.demo.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
// import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue (strategy=GenerationType.AUTO) // AUTO will increate by one automatically, IDENTITY only provided by MySql, Oracle, SEQUENCE db specific sequence object (select nextval ('hibernate_sequence')), TABLE db table helps maintain
	@Column (name="USER_ID") // @Column provides handle to create specific Column names in the table
	private int userId; // Natural key as it has business significance. If it is not business significant than surrogate key
	
	// If primary key is a combination of several columns e.g we have LoginName object which had 2-3 field which collectively make the primary key 
	// in such cases we cannot use @Embedded along with @Id (surely @GeneratedValue cannot be used) annotations instead we can use @EmbeddedId
	// @EmbeddedId
	// private LoginName userId;
	
	@Column (name="USER_NAME")
    private String userName;
	
	//@Basic (fetch=FetchType.LAZY) // By default it uses @Basic if not specified but we can use to specify fetch type and optional attribute
	@Embedded // It means that the following would be a Value object
	private Address homeAddress;
	
	@Embedded // It means that the following would be a Value object
	@AttributeOverrides ({@AttributeOverride(name="street", column=@Column(name="OFFICE_STREET_NAME")),
						  @AttributeOverride(name="city", column=@Column(name="OFFICE_CITY_NAME")),
						  @AttributeOverride(name="state", column=@Column(name="OFFICE_STATE_NAME")),
						  @AttributeOverride(name="zipcode", column=@Column(name="OFFICE_ZIP_CODE"))
		}) // Above way we can override attribute definition in the Address Value Object so that there wont be any conflict in the column name in the resultant table
	private Address officeAddress;
	
	@Transient // If we do not want hobbies to be stored in DB than mark it transient. It gets ignored.
	private String hobbies;
	
	@Temporal(TemporalType.DATE) // To just save date use TemporalType.DATE for time TemporalType.TIME, DEFAULT is TIMESTAMP
	private Date joinedDate;
	
	@Lob // If column is of type String it would be considered as CLOB else BLOB
	private String description;
    
    public UserDetails() {
    }
    
	public UserDetails(String userName, Address homeAddress, Address officeAddress, String hobbies) {
		super();
		this.userName = userName;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
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
	
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
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
