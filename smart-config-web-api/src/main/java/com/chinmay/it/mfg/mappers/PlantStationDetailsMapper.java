package com.chinmay.it.mfg.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.domains.PlantStationDetails;

@Component
public class PlantStationDetailsMapper {
	
	public PlantStationDetailsBean mapPlantStationDetailsBean(PlantStationDetails plantStationDetails) {
		PlantStationDetailsBean plantStationDetailsBean = new PlantStationDetailsBean();
		plantStationDetailsBean.setId(plantStationDetails.getId());
		plantStationDetailsBean.setStationNumber(plantStationDetails.getStationNumber());
		plantStationDetailsBean.setPlantCode(plantStationDetails.getPlantCode());
		plantStationDetailsBean.setStationName(plantStationDetails.getStationName());
		plantStationDetailsBean.setStatus(plantStationDetails.getStatus());
		plantStationDetailsBean.setStationVersion(plantStationDetails.getStationVersion());
		return plantStationDetailsBean;
	}
	
	public List<PlantStationDetailsBean> mapPlantStationDetailsBeanList(List<PlantStationDetails> plantStationsList) {
		List<PlantStationDetailsBean> plantStationDetailsBeanList = new ArrayList<>();
		for (PlantStationDetails plantStation : plantStationsList) {
			plantStationDetailsBeanList.add(mapPlantStationDetailsBean(plantStation));
		}
		return plantStationDetailsBeanList;
	}

	public PlantStationDetails mapPlantStationDetails(PlantStationDetailsBean plantStationDetailsBean) {
		PlantStationDetails plantStationDetails = new PlantStationDetails();
		plantStationDetails.setId(plantStationDetailsBean.getId());
		plantStationDetails.setStationNumber(plantStationDetailsBean.getStationNumber());
		plantStationDetails.setPlantCode(plantStationDetailsBean.getPlantCode());
		plantStationDetails.setStationName(plantStationDetailsBean.getStationName());
		plantStationDetails.setStatus(plantStationDetailsBean.getStatus());
		plantStationDetails.setStationVersion(plantStationDetailsBean.getStationVersion());
		return plantStationDetails;
	}

}
