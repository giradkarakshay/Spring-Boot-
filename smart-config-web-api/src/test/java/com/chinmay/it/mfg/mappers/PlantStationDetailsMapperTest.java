package com.chinmay.it.mfg.mappers;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.dataBuilders.PlantStationDetailsBuilder;
import com.chinmay.it.mfg.domains.PlantStationDetails;
import com.chinmay.it.mfg.mappers.PlantStationDetailsMapper;

public class PlantStationDetailsMapperTest {
	PlantStationDetailsMapper plantStationDetailsMapper;

	@Before
	public void init() {
		plantStationDetailsMapper = new PlantStationDetailsMapper();
	}

	@Test
	public void whenPlantStationDetailsBeanProvided_mapPlantStationDetailsDomain() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		PlantStationDetails plantStationDetails = plantStationDetailsMapper.mapPlantStationDetails(plantStationDetailsBean);

		assertEquals(plantStationDetailsBean.getId(), plantStationDetails.getId());
		assertEquals(plantStationDetailsBean.getStationNumber(), plantStationDetails.getStationNumber());
		assertEquals(plantStationDetailsBean.getPlantCode(), plantStationDetails.getPlantCode());
		assertEquals(plantStationDetailsBean.getStationName(), plantStationDetails.getStationName());
		assertEquals(plantStationDetailsBean.getStatus(), plantStationDetails.getStatus());
		assertEquals(plantStationDetailsBean.getStationVersion(), plantStationDetails.getStationVersion());
	}

	@Test
	public void whenPlantStationDetailsListProvided_mapToPlantStationDetailsBeanList() {
		List<PlantStationDetails> plantStationDetailsList = PlantStationDetailsBuilder.createPlantStationDetailsList();
		List<PlantStationDetailsBean> plantStationDetailsBeanList = plantStationDetailsMapper.mapPlantStationDetailsBeanList(plantStationDetailsList);

		assertEquals(plantStationDetailsList.size(), plantStationDetailsBeanList.size());
	}
}
