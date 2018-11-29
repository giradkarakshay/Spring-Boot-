package com.chinmay.it.mfg.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PLANT_STATION_DETAILS")
public class PlantStationDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "PLANT_CODE")
	private String plantCode;
	
	@Column(name = "STATION_NUMBER")
	private String stationNumber;
	
	@Column(name = "STATION_NAME")
	private String stationName;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "STATION_VERSION")
	private String stationVersion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlantCode() {
		return plantCode;
	}

	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStationVersion() {
		return stationVersion;
	}

	public void setStationVersion(String stationVersion) {
		this.stationVersion = stationVersion;
	}
}
