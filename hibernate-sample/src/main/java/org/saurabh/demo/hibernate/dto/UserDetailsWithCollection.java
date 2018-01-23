package org.saurabh.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table (name="USER_DETAILS")
public class UserDetailsWithCollection {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="USER_ID") 
	private int userId; 
	
	@Column (name="USER_NAME")
    private String userName;
	
	@ElementCollection (fetch=FetchType.EAGER) // This annotation is required for hibernate to know that it needs to be treated as a list
	@JoinTable (name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID")) // This is used to give custom table name for the Address table by default it will take ParentObj_ValueObj i.e UserDetails_listOfAddress
	@GenericGenerator(name = "hilo-gen", strategy = "hilo") // Hibernate specific generator which is required in @CollectionId
	@CollectionId (columns = {@Column (name="ADDRESS_ID")}, generator = "hilo-gen", type = @Type(type="long")) // This is the only one from hibernate rest are from JPA standard i.e javax.persistence
	private List<Address> listOfAddress = new ArrayList<Address>();
    
    public UserDetailsWithCollection() {
    }
    
	public UserDetailsWithCollection(String userName) {
		super();
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
}
