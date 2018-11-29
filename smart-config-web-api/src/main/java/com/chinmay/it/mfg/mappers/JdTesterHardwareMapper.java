package com.chinmay.it.mfg.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.domains.JdTesterHardware;

@Component
public class JdTesterHardwareMapper {
	public JdTesterHardware mapJdTesterHardware(JdTesterHardwareBean jdTesterHardwareBean) {
		JdTesterHardware jdTesterHardware = new JdTesterHardware();
		jdTesterHardware.setId(jdTesterHardwareBean.getId());
		jdTesterHardware.setPlantStationId(jdTesterHardwareBean.getPlantStationId());
		jdTesterHardware.setBitOffset(jdTesterHardwareBean.getBitOffset());
		jdTesterHardware.setBlockOffset(jdTesterHardwareBean.getBlockOffset());
		jdTesterHardware.setBulkHeadPin(jdTesterHardwareBean.getBulkHeadPin());
		jdTesterHardware.setConnector(jdTesterHardwareBean.getConnector());
		jdTesterHardware.setDescription(jdTesterHardwareBean.getDescription());
		jdTesterHardware.setFelxBoxPin(jdTesterHardwareBean.getFelxBoxPin());
		jdTesterHardware.setFusesRelays(jdTesterHardwareBean.getFusesRelays());
		jdTesterHardware.setHardwareName(jdTesterHardwareBean.getHardwareName());
		jdTesterHardware.setPullUp(jdTesterHardwareBean.getPullUp());
		jdTesterHardware.setPwm(jdTesterHardwareBean.getPwm());
		jdTesterHardware.setRawMaximum(jdTesterHardwareBean.getRawMaximum());
		jdTesterHardware.setRawMinimum(jdTesterHardwareBean.getRawMinimum());
		jdTesterHardware.setScaledMaximum(jdTesterHardwareBean.getScaledMaximum());
		jdTesterHardware.setScaledMinimum(jdTesterHardwareBean.getScaledMinimum());
		jdTesterHardware.setScalingFactor(jdTesterHardwareBean.getScalingFactor());
		jdTesterHardware.setScalingOffset(jdTesterHardwareBean.getScalingOffset());
		jdTesterHardware.setTla(jdTesterHardwareBean.getTla());
		jdTesterHardware.setTypeCode(jdTesterHardwareBean.getTypeCode());
		jdTesterHardware.setUm(jdTesterHardwareBean.getUm());
		return jdTesterHardware;
	}

	public List<JdTesterHardware> mapJdTesterHardwareList(List<JdTesterHardwareBean> jdTesterHardwareBeanList) {
		List<JdTesterHardware> jdTesterHardwareList = new ArrayList<>();
		for (JdTesterHardwareBean jdTesterHardwareBean : jdTesterHardwareBeanList) {
			jdTesterHardwareList.add(mapJdTesterHardware(jdTesterHardwareBean));
		}
		return jdTesterHardwareList;
	}

	public List<JdTesterHardwareBean> mapJdTesterHardwareBeanList(List<JdTesterHardware> jdTesterHardwareList) {
		List<JdTesterHardwareBean> jdTesterHardwareBeanList = new ArrayList<>();
		for (JdTesterHardware jdTesterHardware : jdTesterHardwareList) {
			JdTesterHardwareBean jdTesterHardwareBean = new JdTesterHardwareBean();
			jdTesterHardwareBean.setId(jdTesterHardware.getId());
			jdTesterHardwareBean.setPlantStationId(jdTesterHardware.getPlantStationId());
			jdTesterHardwareBean.setBitOffset(jdTesterHardware.getBitOffset());
			jdTesterHardwareBean.setBlockOffset(jdTesterHardware.getBlockOffset());
			jdTesterHardwareBean.setBulkHeadPin(jdTesterHardware.getBulkHeadPin());
			jdTesterHardwareBean.setConnector(jdTesterHardware.getConnector());
			jdTesterHardwareBean.setDescription(jdTesterHardware.getDescription());
			jdTesterHardwareBean.setFelxBoxPin(jdTesterHardware.getFelxBoxPin());
			jdTesterHardwareBean.setFusesRelays(jdTesterHardware.getFusesRelays());
			jdTesterHardwareBean.setHardwareName(jdTesterHardware.getHardwareName());
			jdTesterHardwareBean.setPullUp(jdTesterHardware.getPullUp());
			jdTesterHardwareBean.setPwm(jdTesterHardware.getPwm());
			jdTesterHardwareBean.setRawMaximum(jdTesterHardware.getRawMaximum());
			jdTesterHardwareBean.setRawMinimum(jdTesterHardware.getRawMinimum());
			jdTesterHardwareBean.setScaledMaximum(jdTesterHardware.getScaledMaximum());
			jdTesterHardwareBean.setScaledMinimum(jdTesterHardware.getScaledMinimum());
			jdTesterHardwareBean.setScalingFactor(jdTesterHardware.getScalingFactor());
			jdTesterHardwareBean.setScalingOffset(jdTesterHardware.getScalingOffset());
			jdTesterHardwareBean.setTla(jdTesterHardware.getTla());
			jdTesterHardwareBean.setTypeCode(jdTesterHardware.getTypeCode());
			jdTesterHardwareBean.setUm(jdTesterHardware.getUm());
			jdTesterHardwareBeanList.add(jdTesterHardwareBean);
		}
		return jdTesterHardwareBeanList;
	}
}
