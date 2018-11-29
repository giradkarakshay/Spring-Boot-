package com.chinmay.it.mfg.dataBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.domains.CanHardware;

public class CanHardwareBuilder {
	public static CanHardwareBean createCanHardwareBean() {
		CanHardwareBean canHardwareBean = new CanHardwareBean();
		canHardwareBean.setAliasName("Alias Name");
		canHardwareBean.setCanDevice(1);
		canHardwareBean.setChannelIndex(2);
		canHardwareBean.setChannelName("Channel Name");
		canHardwareBean.setHardwareIndex(3);
		canHardwareBean.setHardwareType(4);
		canHardwareBean.setPlantStationId("Plant Station Id");
		return canHardwareBean;
	}

	public static List<CanHardwareBean> createCanHardwareBeanList() {
		return Arrays.asList(CanHardwareBuilder.createCanHardwareBean());
	}

	public static List<CanHardware> createCanHardwareList() {
		List<CanHardware> canHardwareList = new ArrayList<>();
		for (int count = 0; count < 5; count++) {
			CanHardware canHardware = new CanHardware();
			canHardware.setAliasName("Alias Name" + count);
			canHardware.setCanDevice(1);
			canHardware.setChannelIndex(2);
			canHardware.setChannelName("Channel Name" + count);
			canHardware.setHardwareIndex(3);
			canHardware.setHardwareType(4);
			canHardware.setPlantStationId("Plant Station Id" + count);
			canHardwareList.add(canHardware);
		}
		return canHardwareList;
	}
}
