package com.chinmay.it.mfg.dataBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.domains.ConfigSetting;

public class ConfigSettingBuilder {
	public static ConfigSettingBean createConfigSettingBean() {
		ConfigSettingBean configSettingBean = new ConfigSettingBean();
		configSettingBean.setKey("key1");
		configSettingBean.setPlantStationId("Plant Station Id");
		configSettingBean.setValue("Value");
		configSettingBean.setValue2("Value2");
		return configSettingBean;
	}

	public static List<ConfigSettingBean> createConfigSettingBeanList() {
		return Arrays.asList(ConfigSettingBuilder.createConfigSettingBean());
	}

	public static List<ConfigSetting> createConfigSettingList() {
		List<ConfigSetting> configSettingList = new ArrayList<>();
		for (int count = 0; count < 5; count++) {
			ConfigSetting configSetting = new ConfigSetting();
			configSetting.setPlantStationId("Plant Station Id" + count);
			configSetting.setValue2("Value2" + count);
			configSetting.setValue("Value" + count);
			configSetting.setKey("Key" + count);
			configSettingList.add(configSetting);
		}
		return configSettingList;
	}
}
