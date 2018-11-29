package com.chinmay.it.mfg.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CONFIG_SETTING")
public class ConfigSetting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "PLANT_STATION_ID")
	private String plantStationId;

	@Column(name = "CS_Key")
	private String key;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "VALUE2")
	private String value2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlantStationId() {
		return plantStationId;
	}

	public void setPlantStationId(String plantStationId) {
		this.plantStationId = plantStationId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

}
