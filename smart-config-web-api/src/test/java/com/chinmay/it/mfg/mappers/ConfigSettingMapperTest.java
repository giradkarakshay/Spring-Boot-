package com.chinmay.it.mfg.mappers;

import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.dataBuilders.ConfigSettingBuilder;
import com.chinmay.it.mfg.domains.ConfigSetting;
import com.chinmay.it.mfg.mappers.ConfigSettingMapper;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sk03644 on 03-Aug-18.
 */
public class ConfigSettingMapperTest {
    ConfigSettingMapper configSettingMapper;
    @Before
    public void init() { configSettingMapper = new ConfigSettingMapper(); }
    @Test
    public void whenConfigSettingBeanProvided_mapToConfigSettingDomain(){
        ConfigSettingBean configSettingBean = ConfigSettingBuilder.createConfigSettingBean();
        ConfigSetting configSetting = configSettingMapper.mapConfigSetting(configSettingBean);

        assertEquals(configSettingBean.getKey(), configSetting.getKey());
        assertEquals(configSettingBean.getValue(), configSetting.getValue());
        assertEquals(configSettingBean.getValue2(), configSetting.getValue2());
        assertEquals(configSettingBean.getPlantStationId(), configSetting.getPlantStationId());
    }

    @Test
    public void whenConfigSettingListProvided_mapToConfigSettingBeanList(){
        List<ConfigSetting> configSettingList = ConfigSettingBuilder.createConfigSettingList();
        List<ConfigSettingBean> configSettingBeanList = configSettingMapper.mapConfigSettingBeanList(configSettingList);

        assertEquals(configSettingList.size(),configSettingBeanList.size());
    }
}
