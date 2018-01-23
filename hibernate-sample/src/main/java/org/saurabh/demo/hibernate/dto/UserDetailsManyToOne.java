package org.saurabh.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="USER_DETAILS")
public class UserDetailsManyToOne {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="USER_ID") 
	private int userId; 
	
	@Column (name="USER_NAME")
    private String userName;
	
	// @OneToMany //- Normal case when creating mapping table uncomment this line and below line
	// @JoinTable (name="USER_VEHICLE_DETAILS", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")) // This will configure the 3rd mapping table column names
	// Instead of new table getting created for the mapping of UserDetails and Vehicle entities we can have user_id column in Vehicle table also
	// For Many to Many case used mappedBy="userDetails" present in VehicleManyToOne class
	@OneToMany (mappedBy="userDetails")
	private Collection<VehicleManyToOne> vehicles = new ArrayList<VehicleManyToOne>();
    
    public UserDetailsManyToOne() {
    }
    
	public UserDetailsManyToOne(String userName) {
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

	public Collection<VehicleManyToOne> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<VehicleManyToOne> vehicles) {
		this.vehicles = vehicles;
	}
}
