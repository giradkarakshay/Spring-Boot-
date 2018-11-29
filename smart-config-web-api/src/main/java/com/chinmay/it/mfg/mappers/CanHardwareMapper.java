package com.chinmay.it.mfg.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.domains.CanHardware;

@Component
public class CanHardwareMapper {
	public CanHardware mapCanHardware(CanHardwareBean canHardwareBean) {
		CanHardware canHardware = new CanHardware();
		canHardware.setId(canHardwareBean.getId());
		canHardware.setPlantStationId(canHardwareBean.getPlantStationId());
		canHardware.setAliasName(canHardwareBean.getAliasName());
		canHardware.setCanDevice(canHardwareBean.getCanDevice());
		canHardware.setChannelIndex(canHardwareBean.getChannelIndex());
		canHardware.setChannelName(canHardwareBean.getChannelName());
		canHardware.setHardwareIndex(canHardwareBean.getHardwareIndex());
		canHardware.setHardwareType(canHardwareBean.getHardwareType());
		return canHardware;
	}

	public List<CanHardware> mapCanHardwareList(List<CanHardwareBean> canHardwareBeanList) {
		List<CanHardware> canHardwareList = new ArrayList<>();
		for (CanHardwareBean canHardware : canHardwareBeanList) {
			canHardwareList.add(mapCanHardware(canHardware));
		}
		return canHardwareList;
	}

	public List<CanHardwareBean> mapCanHardwareBeanList(List<CanHardware> canHardwareList) {
		List<CanHardwareBean> canHardwareBeanList = new ArrayList<>();
		for (CanHardware canHardware : canHardwareList) {
			CanHardwareBean canHardwareBean = new CanHardwareBean();
			canHardwareBean.setId(canHardware.getId());
			canHardwareBean.setPlantStationId(canHardware.getPlantStationId());
			canHardwareBean.setAliasName(canHardware.getAliasName());
			canHardwareBean.setCanDevice(canHardware.getCanDevice());
			canHardwareBean.setChannelIndex(canHardware.getChannelIndex());
			canHardwareBean.setChannelName(canHardware.getChannelName());
			canHardwareBean.setHardwareIndex(canHardware.getHardwareIndex());
			canHardwareBean.setHardwareType(canHardware.getHardwareType());
			canHardwareBeanList.add(canHardwareBean);
		}
		return canHardwareBeanList;
	}
}
