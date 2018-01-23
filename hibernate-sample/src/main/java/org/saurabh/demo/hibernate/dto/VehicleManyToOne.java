package org.saurabh.demo.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table (name="USER_VEHICLE")
public class VehicleManyToOne {
	
	@Id
	@GeneratedValue
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn (name="USER_ID")
	@NotFound (action=NotFoundAction.IGNORE) // This would be useful when a Vehicle is not mapped to any user and yet need to be created
	private UserDetailsManyToOne userDetails;
	
	public VehicleManyToOne() {
	}

	public VehicleManyToOne(String vehicleName) {
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

	public UserDetailsManyToOne getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsManyToOne userDetails) {
		this.userDetails = userDetails;
	}
}
