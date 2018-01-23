package org.saurabh.demo.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * 
 * This scenario can be a case where each vehicle being a rental vehicle can be 
 * owned by multiple people likewise each user can have multiple vehicles or rental vehicles
 *
 */
@Entity
@Table (name="USER_VEHICLE")
public class VehicleManyToMany {
	
	@Id
	@GeneratedValue
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToMany (mappedBy="vehicles") // Use mappedBy in @ManyToMany to let hibernate know to create only one mapping table at the UserDetail entity side
	private Collection<UserDetailsManyToMany> userList = new ArrayList<UserDetailsManyToMany>();
	
	public VehicleManyToMany() {
	}

	public VehicleManyToMany(String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<UserDetailsManyToMany> getUserList() {
		return userList;
	}

	public void setUserList(Collection<UserDetailsManyToMany> userList) {
		this.userList = userList;
	}
}
