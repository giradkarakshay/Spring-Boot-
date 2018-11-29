package integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinmay.it.mfg.Application;
import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.dataBuilders.ConfigSettingBuilder;
import com.chinmay.it.mfg.domains.ConfigSetting;
import com.chinmay.it.mfg.mappers.ConfigSettingMapper;
import com.chinmay.it.mfg.repositories.ConfigSettingDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfigSettingDAOIntegrationTest {

	@Autowired
	private ConfigSettingDAO configSettingDAO;

	@Autowired
	private ConfigSettingMapper configSettingMapper;

	@Test
	public void givenConfigSettingBeanSaveConfigSettingData() {
		ConfigSettingBean configSettingBean = ConfigSettingBuilder.createConfigSettingBean();
		configSettingDAO.saveAndFlush(configSettingMapper.mapConfigSetting(configSettingBean));
		Assert.assertEquals(2, configSettingDAO.count());
	}

	@Test
	public void givenPlantStationIdFetchConfigSettingData() {
		ConfigSettingBean configSettingBean = ConfigSettingBuilder.createConfigSettingBean();
		configSettingDAO.save(configSettingMapper.mapConfigSetting(configSettingBean));
		List<ConfigSetting> configSettingList = configSettingDAO.fetchConfigSetting("Plant Station Id");
		Assert.assertEquals(1, configSettingList.size());
	}

	@Test
	public void givenPlantStationIdDeleteConfigSettingData() {
		ConfigSettingBean configSettingBean = ConfigSettingBuilder.createConfigSettingBean();
		configSettingDAO.save(configSettingMapper.mapConfigSetting(configSettingBean));
		configSettingDAO.deleteByPlantStationId("Plant Station Id");
		List<ConfigSetting> configSettingList = configSettingDAO.fetchConfigSetting("Plant Station Id");
		Assert.assertEquals(0, configSettingList.size());
	}

}
