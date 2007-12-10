package com.merrill.hibsamples.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="PRT_PORT_MST")
@NamedQueries({
	@NamedQuery(
			name="companyPorts",
			query="select p from Port p where p.sharjahPorts is not null and p.sharjahPorts='Y' order by p.portName "
	),
	@NamedQuery(
			name="allPorts",
			query="select p from Port p order by p.portName"
	),
	@NamedQuery(
			name="portsForCountry",
			query="select p from Port p where p.countryCode= :_countryCode order by p.portName"
	),
	@NamedQuery(
			name="portForNameMatch",
			query="select p from Port p where p.portName LIKE :_likePortName or p.portName = :_portName  order by p.portName"
	)
}
)
public class Port implements Serializable {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PORT_ID")
	private Long id;

	@Column(name="PORT_CODE")
	private String portCode;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	@Column(name="PORT_DESC")
	private String portDesc;

	@Column(name="ENTERED_BY")
	private String enteredBy;

	@Column(name="SHARJAH_PORTS")
	private String sharjahPorts;

	@Column(name="PORT_NAME")
	private String portName;

	@Version
	private int version;

	private static final long serialVersionUID = 1L;

	public Port() {
		super();
	}

	public String getPortCode() {
		return this.portCode;
	}

	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPortDesc() {
		return this.portDesc;
	}

	public void setPortDesc(String portDesc) {
		this.portDesc = portDesc;
	}

	public String getEnteredBy() {
		return this.enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getSharjahPorts() {
		return this.sharjahPorts;
	}

	public void setSharjahPorts(String sharjahPorts) {
		this.sharjahPorts = sharjahPorts;
	}

	public String getPortName() {
		return this.portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	public Long getId(){
			return this.id;
	}



}
