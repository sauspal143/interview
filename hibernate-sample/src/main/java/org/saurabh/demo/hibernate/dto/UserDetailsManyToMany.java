package org.saurabh.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table (name="USER_DETAILS")
public class UserDetailsManyToMany {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="USER_ID") 
	private int userId; 
	
	@Column (name="USER_NAME")
    private String userName;
	
	@ManyToMany
	@JoinTable (name="USER_VEHICLE_DETAILS", joinColumns=@JoinColumn(name = "USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<VehicleManyToMany> vehicles = new ArrayList<VehicleManyToMany>();
    
    public UserDetailsManyToMany() {
    }
    
	public UserDetailsManyToMany(String userName) {
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

	public Collection<VehicleManyToMany> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<VehicleManyToMany> vehicles) {
		this.vehicles = vehicles;
	}
}
