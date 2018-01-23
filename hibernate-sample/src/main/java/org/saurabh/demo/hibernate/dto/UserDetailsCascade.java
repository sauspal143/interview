package org.saurabh.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="USER_DETAILS")
public class UserDetailsCascade {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO) 
	@Column (name="USER_ID") 
	private int userId; 
	
	@Column (name="USER_NAME")
    private String userName;
	
	@OneToMany (cascade=CascadeType.PERSIST) // cascade=CascadeType.ALL caters all PERSIST, MERGE, REMOVE etc
	@JoinTable (name="USER_VEHICLE_DETAILS", joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")) // This will configure the 3rd mapping table column names
	private Collection<VehicleCascade> vehicles = new ArrayList<VehicleCascade>();
    
    public UserDetailsCascade() {
    }
    
	public UserDetailsCascade(String userName) {
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

	public Collection<VehicleCascade> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<VehicleCascade> vehicles) {
		this.vehicles = vehicles;
	}
}
