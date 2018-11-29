package com.chinmay.it.mfg.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CAN_HW")
public class CanHardware implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "PLANT_STATION_ID")
	private String plantStationId;

	@Column(name = "CHANNEL_NAME")
	private String channelName;

	@Column(name = "CAN_DEVICE")
	private Integer canDevice;

	@Column(name = "HW_INDEX")
	private Integer hardwareIndex;

	@Column(name = "CHANNEL_INDEX")
	private Integer channelIndex;

	@Column(name = "HW_TYPE")
	private Integer hardwareType;

	@Column(name = "ALIAS_NAME")
	private String aliasName;

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

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getCanDevice() {
		return canDevice;
	}

	public void setCanDevice(Integer canDevice) {
		this.canDevice = canDevice;
	}

	public Integer getHardwareIndex() {
		return hardwareIndex;
	}

	public void setHardwareIndex(Integer hardwareIndex) {
		this.hardwareIndex = hardwareIndex;
	}

	public Integer getChannelIndex() {
		return channelIndex;
	}

	public void setChannelIndex(Integer channelIndex) {
		this.channelIndex = channelIndex;
	}

	public Integer getHardwareType() {
		return hardwareType;
	}

	public void setHardwareType(Integer hardwareType) {
		this.hardwareType = hardwareType;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

}
