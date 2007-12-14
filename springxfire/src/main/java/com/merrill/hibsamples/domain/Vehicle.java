/**
 * 
 */
package com.merrill.hibsamples.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author merrill.paul
 *
 */
@Entity
@Table(name="PRT_VEHICLE")
@NamedQueries({
	@NamedQuery(name="vehicleofMake",
			query ="select v from Vehicle v where v.make.makeNo = :makeNumber order by v.registrationNumber "
	)
}
		)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEH_ID")
	private Long id;
	
	@Column(name="REG_NUMBER",length=20)
	private String registrationNumber;
	
	@Column(name="MODEL_YEAR")
	private String modelYear;
	
	@Column(name="DOP")
	private Calendar purchaseDate;
	
	@Version
	private int version;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VEH_MAKE_ID")
	private VehicleMake make;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public Calendar getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Calendar purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public VehicleMake getMake() {
		return make;
	}

	public void setMake(VehicleMake make) {
		this.make = make;
	}

	public Long getId() {
		return id;
	}
}
