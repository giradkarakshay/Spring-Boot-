package com.chinmay.it.mfg.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.dataBuilders.CanHardwareBuilder;
import com.chinmay.it.mfg.dataBuilders.ConfigSettingBuilder;
import com.chinmay.it.mfg.dataBuilders.JdTesterHardwareBuilder;
import com.chinmay.it.mfg.dataBuilders.PlantStationDetailsBuilder;
import com.chinmay.it.mfg.domains.CanHardware;
import com.chinmay.it.mfg.domains.ConfigSetting;
import com.chinmay.it.mfg.domains.JdTesterHardware;
import com.chinmay.it.mfg.domains.PlantStationDetails;
import com.chinmay.it.mfg.mappers.CanHardwareMapper;
import com.chinmay.it.mfg.mappers.ConfigSettingMapper;
import com.chinmay.it.mfg.mappers.JdTesterHardwareMapper;
import com.chinmay.it.mfg.mappers.PlantStationDetailsMapper;
import com.chinmay.it.mfg.repositories.CanHardwareDAO;
import com.chinmay.it.mfg.repositories.ConfigSettingDAO;
import com.chinmay.it.mfg.repositories.JdTesterHardwareDAO;
import com.chinmay.it.mfg.repositories.PlantStationDetailsDAO;
import com.chinmay.it.mfg.services.SmartTestConfigService;

@RunWith(MockitoJUnitRunner.class)
public class SmartTestConfigServiceTest {
	
	private String plantCode = "RX01";
		
	private List<PlantStationDetailsBean> plantStationDetailsBeanList = new ArrayList<>();
	private List<ConfigSettingBean> configSettingBeanList = new ArrayList<>();
	private List<CanHardwareBean> canHardwareBeanList = new ArrayList<>();
	private List<JdTesterHardwareBean> jdTesterHardwareBeanList = new ArrayList<>();
	
	private List<PlantStationDetails> plantStationDetailsList = new ArrayList<>();
	private List<ConfigSetting> configSettingList = new ArrayList<>();
	private List<CanHardware> canHardwareList = new ArrayList<>();
	private List<JdTesterHardware> jdTesterHardwareList = new ArrayList<>();

	@Mock
	CanHardwareDAO canHardwareDAO;
	@Mock
	ConfigSettingDAO configSettingDAO;
	@Mock
	JdTesterHardwareDAO jdTesterHardwareDAO;
	@Mock
	PlantStationDetailsDAO plantStationDetailsDAO;
	
	@Mock
	CanHardwareMapper canHardwareMapper;
	@Mock
	ConfigSettingMapper configSettingMapper;
	@Mock
	JdTesterHardwareMapper jdTesterHardwareMapper;
	@Mock
	PlantStationDetailsMapper plantStationDetailsMapper;
	
	SmartTestConfigService smartTestConfigService;

	@Before
	public void init() {
		smartTestConfigService = new SmartTestConfigService(canHardwareDAO, canHardwareMapper, configSettingDAO,
				configSettingMapper, jdTesterHardwareDAO, jdTesterHardwareMapper, plantStationDetailsDAO, plantStationDetailsMapper);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenCanHardwareInputProvided_mapCanHardwareDomainMapperAndSaveCanHardwareDAO() {
		canHardwareBeanList = CanHardwareBuilder.createCanHardwareBeanList();
		when(canHardwareMapper.mapCanHardwareList(anyList())).thenReturn(canHardwareList);
		when(canHardwareDAO.save(anyList())).thenReturn(canHardwareList);
		Assert.assertTrue(smartTestConfigService.saveCanHardwareList(canHardwareBeanList));
		verify(canHardwareMapper).mapCanHardwareList(canHardwareBeanList);
		verify(canHardwareDAO).save(canHardwareList);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenConfigSettingInputProvided_mapConfigSettingDomainMapperAndSaveConfigSettingDAO() {
		configSettingBeanList = ConfigSettingBuilder.createConfigSettingBeanList();
		when(configSettingMapper.mapCanHardwareList(anyList())).thenReturn(configSettingList);
		when(configSettingDAO.save(anyList())).thenReturn(configSettingList);
		Assert.assertTrue(smartTestConfigService.saveConfigSettingList(configSettingBeanList));
		verify(configSettingMapper).mapCanHardwareList(configSettingBeanList);
		verify(configSettingDAO).save(configSettingList);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenJdTesterHardwareInputProvided_mapJdTesterHardwareDomainMapperAndSaveJdTesterHardwareDAO() {
		jdTesterHardwareBeanList = JdTesterHardwareBuilder.createJdTesterHardwareBeanList();
		when(jdTesterHardwareMapper.mapJdTesterHardwareList(anyList())).thenReturn(jdTesterHardwareList);
		when(jdTesterHardwareDAO.save(anyList())).thenReturn(jdTesterHardwareList);
		Assert.assertTrue(smartTestConfigService.saveJdTesterHardwareList(jdTesterHardwareBeanList));
		verify(jdTesterHardwareMapper).mapJdTesterHardwareList(jdTesterHardwareBeanList);
		verify(jdTesterHardwareDAO).save(jdTesterHardwareList);
	}

	@Test
	public void whenPlantStationDetailsInputProvided_mapPlantStationDetailsDomainMapperAndSavePlantStationDetailsDAO() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		PlantStationDetails plantStationDetails = PlantStationDetailsBuilder.createPlantStationDetails();
		when(plantStationDetailsMapper.mapPlantStationDetails(any())).thenReturn(plantStationDetails);
		when(plantStationDetailsDAO.saveAndFlush(any())).thenReturn(plantStationDetails);
		when(plantStationDetailsMapper.mapPlantStationDetailsBean(any())).thenReturn(plantStationDetailsBean);
		assertNotNull(smartTestConfigService.savePlantStationDetails(plantStationDetailsBean));
		verify(plantStationDetailsMapper).mapPlantStationDetails(plantStationDetailsBean);
		verify(plantStationDetailsDAO).saveAndFlush(plantStationDetails);
	}

	@Test
	public void whenInputsProvided_getPlantStationDetailsFromDAOAndDelegateToBeanMapper() {
		when(plantStationDetailsDAO.fetchPlantStationDetails(anyString())).thenReturn(plantStationDetailsList);
		when(plantStationDetailsMapper.mapPlantStationDetailsBeanList(plantStationDetailsList)).thenReturn(new ArrayList<>());

		plantStationDetailsBeanList = smartTestConfigService.fetchPlantStationDetails(plantCode);

		verify(plantStationDetailsDAO).fetchPlantStationDetails(plantCode);
		verify(plantStationDetailsMapper).mapPlantStationDetailsBeanList(plantStationDetailsList);
		assertEquals(0, plantStationDetailsBeanList.size());
	}

	@Test
	public void whenFetchCanHardwareWithProperInputs_FetchCanHardwareIsRetrieved() throws Exception {
		when(canHardwareMapper.mapCanHardwareBeanList(any())).thenReturn(canHardwareBeanList);
		when(canHardwareDAO.fetchCanHardware(anyString())).thenReturn(canHardwareList);
		canHardwareBeanList = smartTestConfigService.fetchCanHardware(plantCode);
		assertNotNull(canHardwareBeanList);
	}

	@Test
	public void whenFetchConfigSettingWithProperInputs_FetchConfigSettingIsRetrieved() throws Exception {
		when(configSettingMapper.mapConfigSettingBeanList(any())).thenReturn(configSettingBeanList);
		when(configSettingDAO.fetchConfigSetting(anyString())).thenReturn(configSettingList);
		configSettingBeanList = smartTestConfigService.fetchConfigSetting(plantCode);
		assertNotNull(configSettingBeanList);
	}

	@Test
	public void whenFetchJdTesterHardwareWithProperInputs_FetchJdTesterHardwareIsRetrieved() throws Exception {
		when(jdTesterHardwareMapper.mapJdTesterHardwareBeanList(any())).thenReturn(jdTesterHardwareBeanList);
		when(jdTesterHardwareDAO.fetchJdTesterHardware(anyString())).thenReturn(jdTesterHardwareList);
		jdTesterHardwareBeanList = smartTestConfigService.fetchJdTesterHardware(plantCode);
		assertNotNull(jdTesterHardwareBeanList);
	}

	@Test
	public void whenFetchPlantStationDetailsWithProperInputs_FetchPlantStationDetailsIsRetrieved() throws Exception {
		when(plantStationDetailsMapper.mapPlantStationDetailsBeanList(any())).thenReturn(plantStationDetailsBeanList);
		when(plantStationDetailsDAO.fetchPlantStationDetails(anyString())).thenReturn(plantStationDetailsList);
		plantStationDetailsBeanList = smartTestConfigService.fetchPlantStationDetails(plantCode);
		assertNotNull(plantStationDetailsBeanList);
	}
}
