package com.chinmay.it.mfg.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.controllers.SmartTestConfigController;
import com.chinmay.it.mfg.dataBuilders.CanHardwareBuilder;
import com.chinmay.it.mfg.dataBuilders.ConfigSettingBuilder;
import com.chinmay.it.mfg.dataBuilders.JdTesterHardwareBuilder;
import com.chinmay.it.mfg.dataBuilders.PlantStationDetailsBuilder;
import com.chinmay.it.mfg.services.SmartTestConfigService;

@RunWith(MockitoJUnitRunner.class)
public class SmartTestConfigControllerTest {

	@Mock
	SmartTestConfigService smartTestConfigService;
	SmartTestConfigController smartTestConfigController;
	
	@Before
	public void init() {
		smartTestConfigController = new SmartTestConfigController(smartTestConfigService);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenSaveCanHardwareWithProperInputs_DataIsSaved() {
		when(smartTestConfigService.saveCanHardwareList(anyList())).thenReturn(true);
		boolean isSaveCanHardwareSuccess = smartTestConfigController.saveCanHardwareList(CanHardwareBuilder.createCanHardwareBeanList());
		Assert.assertTrue(isSaveCanHardwareSuccess);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenSaveConfigSettingWithProperInputs_DataIsSaved() {
		when(smartTestConfigService.saveConfigSettingList(anyList())).thenReturn(true);
		boolean isSaveConfigSettingSuccess = smartTestConfigController.saveConfigSettingList(ConfigSettingBuilder.createConfigSettingBeanList());
		Assert.assertTrue(isSaveConfigSettingSuccess);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenSaveJdTesterHardwareWithProperInputs_DataIsSaved() {
		when(smartTestConfigService.saveJdTesterHardwareList(anyList())).thenReturn(true);
		boolean isSaveJdTesterHardwareSuccess = smartTestConfigController.saveJdTesterHardwareList(JdTesterHardwareBuilder.createJdTesterHardwareBeanList());
		Assert.assertTrue(isSaveJdTesterHardwareSuccess);
	}

	@Test
	public void whenSavePlantStationDetailsWithProperInputs_DataIsSaved() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		when(smartTestConfigService.savePlantStationDetails(any())).thenReturn(plantStationDetailsBean);
		PlantStationDetailsBean plantStationDetailsBeanResponse = smartTestConfigController.savePlantStationDetails(plantStationDetailsBean);
		assertNotNull(plantStationDetailsBeanResponse);
	}

	@Test
	public void whenFetchPlantStationDetailsWithProperInputs_FetchPlantStationDetailsOutputIsRetrieved()
			throws Exception {
		List<PlantStationDetailsBean> plantStationDetailsBeanList = new ArrayList<>();
		when(smartTestConfigService.fetchPlantStationDetails(anyString())).thenReturn(plantStationDetailsBeanList);

		ResponseEntity<List<PlantStationDetailsBean>> plantStationDetailsBeanListResponseEntity = smartTestConfigController.fetchUnitCodeDetails();

		assertEquals(HttpStatus.OK, plantStationDetailsBeanListResponseEntity.getStatusCode());
		assertNotNull(plantStationDetailsBeanListResponseEntity.getBody());
	}
	
	@Test
	public void whenDeletePlantStationDetailsWithProperInputs_PlantStationDetailsIsDeleted()
			throws Exception {
		when(smartTestConfigService.deleteWorkStationDetails(anyString())).thenReturn(true);
		boolean deleteResponse = smartTestConfigController.deleteWorkStationDetails("id");
		assertEquals(true,deleteResponse);
	}

	@Test
	public void whenFetchPlantStationIdWithStationNumber_FetchPlantStationIdIsRetrieved()
			throws Exception {
		when(smartTestConfigService.fetchPlantStationId(anyString())).thenReturn(PlantStationDetailsBuilder.createPlantStationDetailsBean());

		ResponseEntity<PlantStationDetailsBean> plantStationIdResponseEntity = smartTestConfigController.fetchPlantStationId("RX01");

		assertEquals(HttpStatus.OK, plantStationIdResponseEntity.getStatusCode());
		assertNotNull(plantStationIdResponseEntity.getBody());
	}

	@Test
	public void whenFetchCanHardwareWithProperInputs_FetchCanHardwareIsRetrieved()
			throws Exception {
		when(smartTestConfigService.fetchCanHardware(anyString())).thenReturn(CanHardwareBuilder.createCanHardwareBeanList());

		ResponseEntity<List<CanHardwareBean>> canHardwareResponseEntity = smartTestConfigController.fetchCanHardware("RX01");

		assertEquals(HttpStatus.OK, canHardwareResponseEntity.getStatusCode());
		assertNotNull(canHardwareResponseEntity.getBody());
	}

	@Test
	public void whenFetchConfigSettingWithProperInputs_FetchConfigSettingIsRetrieved()
			throws Exception {
		when(smartTestConfigService.fetchConfigSetting(anyString())).thenReturn(ConfigSettingBuilder.createConfigSettingBeanList());

		ResponseEntity<List<ConfigSettingBean>> configSettingResponseEntity = smartTestConfigController.fetchConfigSetting("RX01");

		assertEquals(HttpStatus.OK, configSettingResponseEntity.getStatusCode());
		assertNotNull(configSettingResponseEntity.getBody());
	}

	@Test
	public void whenFetchJdTesterHardwareWithProperInputs_FetchJdTesterHardwareIsRetrieved()
			throws Exception {
		List<JdTesterHardwareBean> jdTesterHardwareBeanList = new ArrayList<>();
		when(smartTestConfigService.fetchJdTesterHardware(anyString())).thenReturn(jdTesterHardwareBeanList);

		ResponseEntity<List<JdTesterHardwareBean>> jdTesterHardwareResponseEntity = smartTestConfigController.fetchJdTesterHardware("RX01");

		assertEquals(HttpStatus.OK, jdTesterHardwareResponseEntity.getStatusCode());
		assertNotNull(jdTesterHardwareResponseEntity.getBody());
	}
	
}
