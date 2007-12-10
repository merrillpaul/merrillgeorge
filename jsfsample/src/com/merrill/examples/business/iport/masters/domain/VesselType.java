package com.merrill.examples.business.iport.masters.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PRT_VESSELTYPE_MST")
@NamedQuery(
		name="allVesselTypes",
		query="select vt from VesselType vt order by vt.vesselType"
		)
public class VesselType implements Serializable {
	@Id
	@Column(name="VESSEL_TYPE")
	private String vesselType;

	@Column(name="ENTERED_BY")
	private String enteredBy;

	@Column(name="VESSEL_TYPE_DESC")
	private String vesselTypeDesc;

	private static final long serialVersionUID = 1L;

	public VesselType() {
		super();
	}

	public String getVesselType() {
		return this.vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public String getEnteredBy() {
		return this.enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getVesselTypeDesc() {
		return this.vesselTypeDesc;
	}

	public void setVesselTypeDesc(String vesselTypeDesc) {
		this.vesselTypeDesc = vesselTypeDesc;
	}

}
