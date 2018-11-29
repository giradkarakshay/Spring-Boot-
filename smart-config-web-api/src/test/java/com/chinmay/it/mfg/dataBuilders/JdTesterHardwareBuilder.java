package com.chinmay.it.mfg.dataBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.domains.JdTesterHardware;

public class JdTesterHardwareBuilder {
	public static JdTesterHardwareBean createJdTesterHardwareBean() {
		JdTesterHardwareBean jdTesterHardwareBean = new JdTesterHardwareBean();
		jdTesterHardwareBean.setId("47f3553a-1013-43ff-9f2c-fdc11bc09b9e");
		jdTesterHardwareBean.setPlantStationId("Plant Station Id");
		jdTesterHardwareBean.setBitOffset(1);
		jdTesterHardwareBean.setBlockOffset(2);
		jdTesterHardwareBean.setBulkHeadPin("Bulk Head Pin");
		jdTesterHardwareBean.setConnector("Connector");
		jdTesterHardwareBean.setDescription("Description");
		jdTesterHardwareBean.setFelxBoxPin("FlexBoxPin");
		jdTesterHardwareBean.setFusesRelays("FusesRelays");
		jdTesterHardwareBean.setHardwareName("HardwareName");
		jdTesterHardwareBean.setPullUp("PullUp");
		jdTesterHardwareBean.setPwm("Pwm");
		jdTesterHardwareBean.setRawMaximum(3);
		jdTesterHardwareBean.setRawMinimum(4);
		jdTesterHardwareBean.setScaledMaximum(5);
		jdTesterHardwareBean.setScaledMinimum(6);
		jdTesterHardwareBean.setScalingFactor(7);
		jdTesterHardwareBean.setScalingOffset(8);
		jdTesterHardwareBean.setTla("TLA");
		jdTesterHardwareBean.setTypeCode("TypeCode");
		jdTesterHardwareBean.setUm("UM");
		return jdTesterHardwareBean;
	}

	public static List<JdTesterHardwareBean> createJdTesterHardwareBeanList() {
		return Arrays.asList(JdTesterHardwareBuilder.createJdTesterHardwareBean());
	}

	public static List<JdTesterHardware> createJdTesterHardwareList() {
		List<JdTesterHardware> jdTesterHardwareList = new ArrayList<>();
		for (int count = 0; count < 5; count++) {
			JdTesterHardware jdTesterHardware = new JdTesterHardware();
			jdTesterHardware.setId("47f3553a-1013-43ff-" + count + "f2c-fdc11bc09b9e");
			jdTesterHardware.setPlantStationId("Plant Station Id" + count);
			jdTesterHardware.setBitOffset(1);
			jdTesterHardware.setBlockOffset(2);
			jdTesterHardware.setBulkHeadPin("Bulk Head Pin");
			jdTesterHardware.setConnector("Connector");
			jdTesterHardware.setDescription("Description");
			jdTesterHardware.setFelxBoxPin("FlexBoxPin");
			jdTesterHardware.setFusesRelays("FusesRelays");
			jdTesterHardware.setHardwareName("HardwareName");
			jdTesterHardware.setPullUp("PullUp");
			jdTesterHardware.setPwm("Pwm");
			jdTesterHardware.setRawMaximum(3);
			jdTesterHardware.setRawMinimum(4);
			jdTesterHardware.setScaledMaximum(5);
			jdTesterHardware.setScaledMinimum(6);
			jdTesterHardware.setScalingFactor(7);
			jdTesterHardware.setScalingOffset(8);
			jdTesterHardware.setTla("TLA");
			jdTesterHardware.setTypeCode("TypeCode");
			jdTesterHardware.setUm("UM");
			jdTesterHardwareList.add(jdTesterHardware);
		}
		return jdTesterHardwareList;
	}
}
