package com.merrill.examples.business.iport.masters.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRT_MAKE_MST")
public class VehicleMake implements Serializable {
	@Id
	@Column(name="MAKE_NO")
	private String makeNo;

	private String model;

	@Column(name="MAKE_NAME")
	private String makeName;

	private static final long serialVersionUID = 1L;

	public VehicleMake() {
		super();
	}

	public String getMakeNo() {
		return this.makeNo;
	}

	public void setMakeNo(String makeNo) {
		this.makeNo = makeNo;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMakeName() {
		return this.makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

}
