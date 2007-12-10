package com.merrill.examples.business.iport.masters.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRT_VESSELNATURE_MST")
public class VesselNature implements Serializable {
	@Id
	@Column(name="VESSEL_NATURE")
	private String vesselNature;

	@Column(name="VESSEL_NATURE_DESC")
	private String vesselNatureDesc;

	@Column(name="ENTERED_BY")
	private String enteredBy;

	private static final long serialVersionUID = 1L;

	public VesselNature() {
		super();
	}

	public String getVesselNature() {
		return this.vesselNature;
	}

	public void setVesselNature(String vesselNature) {
		this.vesselNature = vesselNature;
	}

	public String getVesselNatureDesc() {
		return this.vesselNatureDesc;
	}

	public void setVesselNatureDesc(String vesselNatureDesc) {
		this.vesselNatureDesc = vesselNatureDesc;
	}

	public String getEnteredBy() {
		return this.enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

}
