package com.chinmay.it.mfg.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.bean.WorkStationNewBean;
import com.chinmay.it.mfg.services.SmartTestConfigService;

@RequestMapping("/api/v1/")
@RestController
public class SmartTestConfigController {

	private SmartTestConfigService smartTestConfigService;
	
	@Value("${smart-test-config.plantCode}")
	private String plantCode;
	
	@Value("${smart-test-config.configurations}")
	private String[] configurations;

	@Autowired
	public SmartTestConfigController(SmartTestConfigService smartTestConfigService) {
		this.smartTestConfigService = smartTestConfigService;
	}
	
	@GetMapping("/configurations")
	public ResponseEntity<List<String>> configurations() {
		return new ResponseEntity<>(Arrays.asList(configurations), HttpStatus.OK);
	}
	
	@GetMapping("/unitCodeDetails")
	public ResponseEntity<List<PlantStationDetailsBean>> fetchUnitCodeDetails() {
		return new ResponseEntity<>(smartTestConfigService.fetchPlantStationDetails(plantCode), HttpStatus.OK);
	}

	@GetMapping("/plantStationDetails/{id}")
	public ResponseEntity<PlantStationDetailsBean> fetchPlantStationId(@PathVariable("id") String id) {
		return new ResponseEntity<>(smartTestConfigService.fetchPlantStationId(id), HttpStatus.OK);
	}

	@GetMapping("/canHardware/{plantStationId}")
	public ResponseEntity<List<CanHardwareBean>> fetchCanHardware(@PathVariable("plantStationId") String plantStationId) {
		return new ResponseEntity<>(smartTestConfigService.fetchCanHardware(plantStationId), HttpStatus.OK);
	}

	@GetMapping("/configSetting/{plantStationId}")
	public ResponseEntity<List<ConfigSettingBean>> fetchConfigSetting(@PathVariable("plantStationId") String plantStationId) {
		return new ResponseEntity<>(smartTestConfigService.fetchConfigSetting(plantStationId), HttpStatus.OK);
	}

	@GetMapping("/jdTesterHardware/{plantStationId}")
	public ResponseEntity<List<JdTesterHardwareBean>> fetchJdTesterHardware(@PathVariable("plantStationId") String plantStationId) {
		return new ResponseEntity<>(smartTestConfigService.fetchJdTesterHardware(plantStationId), HttpStatus.OK);
	}
	
	@PostMapping("/plantStationDetails")
	public PlantStationDetailsBean savePlantStationDetails(@RequestBody PlantStationDetailsBean plantStationDetailsBean) {
		plantStationDetailsBean.setPlantCode(plantCode);
		return smartTestConfigService.savePlantStationDetails(plantStationDetailsBean);
	}

	@PostMapping("/canHardware")
	public boolean saveCanHardwareList(@RequestBody List<CanHardwareBean> canHardwareBeanList) {
		return smartTestConfigService.saveCanHardwareList(canHardwareBeanList);
	}

	@PostMapping("/configSetting")
	public boolean saveConfigSettingList(@RequestBody List<ConfigSettingBean> configSettingBeanList) {
		return smartTestConfigService.saveConfigSettingList(configSettingBeanList);
	}

	@PostMapping("/jdTesterHardware")
	public boolean saveJdTesterHardwareList(@RequestBody List<JdTesterHardwareBean> jdTesterHardwareBeanList) {
		return smartTestConfigService.saveJdTesterHardwareList(jdTesterHardwareBeanList);
	}
	
	@PostMapping("/saveAll")
	public boolean saveAll(@RequestBody WorkStationNewBean workStationNewBean) {
		workStationNewBean.getPlantStationDetailsBean().setPlantCode(plantCode);
		PlantStationDetailsBean savedPlantStationDetails = smartTestConfigService.savePlantStationDetails(workStationNewBean.getPlantStationDetailsBean());
		smartTestConfigService.saveCanHardwareList(workStationNewBean.getCanHardwareBeanList().stream()
			    .peek(f -> f.setPlantStationId(savedPlantStationDetails.getId())).collect(Collectors.toList()));
		smartTestConfigService.saveConfigSettingList(workStationNewBean.getConfigSettingBeanList().stream()
			    .peek(f -> f.setPlantStationId(savedPlantStationDetails.getId())).collect(Collectors.toList()));
		smartTestConfigService.saveJdTesterHardwareList(workStationNewBean.getJdTesterHardwareBeanList().stream()
			    .peek(f -> f.setPlantStationId(savedPlantStationDetails.getId())).collect(Collectors.toList()));
		return true;
	}

	@DeleteMapping("/workStationDetails/{id}")
	public boolean deleteWorkStationDetails(@PathVariable("id") String id) {
		return smartTestConfigService.deleteWorkStationDetails(id);
	}
	
	@DeleteMapping("/canHardware/{id}")
	public boolean deleteCanHardware(@PathVariable("id") String id) {
		return smartTestConfigService.deleteCanHardware(id);
	}
	
	@DeleteMapping("/configSetting/{id}")
	public boolean deleteConfigSetting(@PathVariable("id") String id) {
		return smartTestConfigService.deleteConfigSetting(id);
	}
	
	@DeleteMapping("/jdTesterHardware/{id}")
	public boolean deleteJdTesterHardware(@PathVariable("id") String id) {
		return smartTestConfigService.deleteJdTesterHardware(id);
	}
	
}
