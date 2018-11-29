package com.chinmay.it.mfg.bean;

import java.util.List;

public class WorkStationNewBean {

	private PlantStationDetailsBean plantStationDetailsBean;
	private List<CanHardwareBean> canHardwareBeanList;
	private List<ConfigSettingBean> configSettingBeanList;
	private List<JdTesterHardwareBean> jdTesterHardwareBeanList;

	public PlantStationDetailsBean getPlantStationDetailsBean() {
		return plantStationDetailsBean;
	}

	public void setPlantStationDetailsBean(PlantStationDetailsBean plantStationDetailsBean) {
		this.plantStationDetailsBean = plantStationDetailsBean;
	}

	public List<CanHardwareBean> getCanHardwareBeanList() {
		return canHardwareBeanList;
	}

	public void setCanHardwareBeanList(List<CanHardwareBean> canHardwareBeanList) {
		this.canHardwareBeanList = canHardwareBeanList;
	}

	public List<ConfigSettingBean> getConfigSettingBeanList() {
		return configSettingBeanList;
	}

	public void setConfigSettingBeanList(List<ConfigSettingBean> configSettingBeanList) {
		this.configSettingBeanList = configSettingBeanList;
	}

	public List<JdTesterHardwareBean> getJdTesterHardwareBeanList() {
		return jdTesterHardwareBeanList;
	}

	public void setJdTesterHardwareBeanList(List<JdTesterHardwareBean> jdTesterHardwareBeanList) {
		this.jdTesterHardwareBeanList = jdTesterHardwareBeanList;
	}

}
