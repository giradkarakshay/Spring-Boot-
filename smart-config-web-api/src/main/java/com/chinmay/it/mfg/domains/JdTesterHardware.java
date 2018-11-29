package com.chinmay.it.mfg.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "JDTESTER_HW")
public class JdTesterHardware implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(name = "PLANT_STATION_ID")
	private String plantStationId;

	@Column(name = "HW_NAME")
	private String hardwareName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TLA")
	private String tla;

	@Column(name = "FLEX_BOX_PIN")
	private String felxBoxPin;

	@Column(name = "TYPE_CODE")
	private String typeCode;

	@Column(name = "BULK_HEAD_PIN")
	private String bulkHeadPin;

	@Column(name = "PULL_UP")
	private String pullUp;

	@Column(name = "PWM")
	private String pwm;

	@Column(name = "CONNECTOR")
	private String connector;

	@Column(name = "FUSES_RELAYS")
	private String fusesRelays;

	@Column(name = "BLOCK_OFFSET")
	private Integer blockOffset;

	@Column(name = "BIT_OFFSET")
	private Integer bitOffset;

	@Column(name = "RAW_MINIMUM")
	private Integer rawMinimum;

	@Column(name = "RAW_MAXIMUM")
	private Integer rawMaximum;

	@Column(name = "SCALING_FACTOR")
	private Integer scalingFactor;

	@Column(name = "SCALING_OFFSET")
	private Integer scalingOffset;

	@Column(name = "SCALED_MINIMUM")
	private Integer scaledMinimum;

	@Column(name = "SCALED_MAXIMUM")
	private Integer scaledMaximum;

	@Column(name = "UM")
	private String um;

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

	public String getHardwareName() {
		return hardwareName;
	}

	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTla() {
		return tla;
	}

	public void setTla(String tla) {
		this.tla = tla;
	}

	public String getFelxBoxPin() {
		return felxBoxPin;
	}

	public void setFelxBoxPin(String felxBoxPin) {
		this.felxBoxPin = felxBoxPin;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getBulkHeadPin() {
		return bulkHeadPin;
	}

	public void setBulkHeadPin(String bulkHeadPin) {
		this.bulkHeadPin = bulkHeadPin;
	}

	public String getPullUp() {
		return pullUp;
	}

	public void setPullUp(String pullUp) {
		this.pullUp = pullUp;
	}

	public String getPwm() {
		return pwm;
	}

	public void setPwm(String pwm) {
		this.pwm = pwm;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getFusesRelays() {
		return fusesRelays;
	}

	public void setFusesRelays(String fusesRelays) {
		this.fusesRelays = fusesRelays;
	}

	public Integer getBlockOffset() {
		return blockOffset;
	}

	public void setBlockOffset(Integer blockOffset) {
		this.blockOffset = blockOffset;
	}

	public Integer getBitOffset() {
		return bitOffset;
	}

	public void setBitOffset(Integer bitOffset) {
		this.bitOffset = bitOffset;
	}

	public Integer getRawMinimum() {
		return rawMinimum;
	}

	public void setRawMinimum(Integer rawMinimum) {
		this.rawMinimum = rawMinimum;
	}

	public Integer getRawMaximum() {
		return rawMaximum;
	}

	public void setRawMaximum(Integer rawMaximum) {
		this.rawMaximum = rawMaximum;
	}

	public Integer getScalingFactor() {
		return scalingFactor;
	}

	public void setScalingFactor(Integer scalingFactor) {
		this.scalingFactor = scalingFactor;
	}

	public Integer getScalingOffset() {
		return scalingOffset;
	}

	public void setScalingOffset(Integer scalingOffset) {
		this.scalingOffset = scalingOffset;
	}

	public Integer getScaledMinimum() {
		return scaledMinimum;
	}

	public void setScaledMinimum(Integer scaledMinimum) {
		this.scaledMinimum = scaledMinimum;
	}

	public Integer getScaledMaximum() {
		return scaledMaximum;
	}

	public void setScaledMaximum(Integer scaledMaximum) {
		this.scaledMaximum = scaledMaximum;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

}
