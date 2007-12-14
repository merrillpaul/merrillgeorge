package com.merrill.hibsamples.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="PRT_MAKE_MST")
public class VehicleMake implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MAKE_ID")
	private Long id;


	@Column(name="MAKE_NO" , unique=true)
	private String makeNo;

	@Column(name="MODEL_NAME", length=20 )
	private String model;

	@Column(name="MAKE_NAME",length=40)
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

	public Long getId(){
			return this.id;
	}

}
