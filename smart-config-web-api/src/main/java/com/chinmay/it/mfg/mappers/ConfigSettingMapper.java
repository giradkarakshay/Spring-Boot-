package com.chinmay.it.mfg.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.domains.ConfigSetting;

@Component
public class ConfigSettingMapper {
	public ConfigSetting mapConfigSetting(ConfigSettingBean configSettingBean) {
		ConfigSetting configSetting = new ConfigSetting();
		configSetting.setId(configSettingBean.getId());
		configSetting.setPlantStationId(configSettingBean.getPlantStationId());
		configSetting.setKey(configSettingBean.getKey());
		configSetting.setValue(configSettingBean.getValue());
		configSetting.setValue2(configSettingBean.getValue2());
		return configSetting;
	}

	public List<ConfigSetting> mapCanHardwareList(List<ConfigSettingBean> configSettingBeanList) {
		List<ConfigSetting> configSettingList = new ArrayList<>();
		for (ConfigSettingBean configSettingBean : configSettingBeanList) {
			configSettingList.add(mapConfigSetting(configSettingBean));
		}
		return configSettingList;
	}

	public List<ConfigSettingBean> mapConfigSettingBeanList(List<ConfigSetting> configSettingList) {
		List<ConfigSettingBean> configSettingBeanList = new ArrayList<>();
		for (ConfigSetting configSetting : configSettingList) {
			ConfigSettingBean configSettingBean = new ConfigSettingBean();
			configSettingBean.setId(configSetting.getId());
			configSettingBean.setPlantStationId(configSetting.getPlantStationId());
			configSettingBean.setKey(configSetting.getKey());
			configSettingBean.setValue(configSetting.getValue());
			configSettingBean.setValue2(configSetting.getValue2());
			configSettingBeanList.add(configSettingBean);
		}
		return configSettingBeanList;
	}
}
