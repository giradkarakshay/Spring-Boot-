package com.chinmay.it.mfg.dataBuilders;

import java.util.Arrays;
import java.util.List;

import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.domains.PlantStationDetails;

public class PlantStationDetailsBuilder {
	public static PlantStationDetailsBean createPlantStationDetailsBean() {
		PlantStationDetailsBean plantStationDetailsBean = new PlantStationDetailsBean();
		plantStationDetailsBean.setId("47f3553a-1013-43ff-9f2c-fdc11bc09b9f");
		plantStationDetailsBean.setStationNumber("Station Number");
		plantStationDetailsBean.setPlantCode("Plant Code");
		return plantStationDetailsBean;
	}

	public static PlantStationDetails createPlantStationDetails() {
		PlantStationDetails plantStationDetails = new PlantStationDetails();
		plantStationDetails.setId("47f3553a-1013-43ff-9f2c-fdc11bc09b9f");
		plantStationDetails.setStationNumber("Station Number");
		plantStationDetails.setPlantCode("Plant Code");
		return plantStationDetails;
	}

	public static List<PlantStationDetails> createPlantStationDetailsList() {
		return Arrays.asList(PlantStationDetailsBuilder.createPlantStationDetails());
	}
}
