package org.saurabh.demo.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name="USER_DETAILS")
public class UserDetailsOneToOne {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="USER_ID") 
	private int userId; 
	
	@Column (name="USER_NAME")
    private String userName;
	
	@OneToOne
	@JoinColumn (name="VEHICLE_ID")
	private Vehicle vehicle;
    
    public UserDetailsOneToOne() {
    }
    
	public UserDetailsOneToOne(String userName) {
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
