package integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinmay.it.mfg.Application;
import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.dataBuilders.PlantStationDetailsBuilder;
import com.chinmay.it.mfg.domains.PlantStationDetails;
import com.chinmay.it.mfg.mappers.PlantStationDetailsMapper;
import com.chinmay.it.mfg.repositories.PlantStationDetailsDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlantStationDetailsDAOIntegrationTest {

	@Autowired
	private PlantStationDetailsDAO plantStationDetailsDAO;

	@Autowired
	private PlantStationDetailsMapper plantStationDetailsMapper;

	@Test
	public void givenPlantStationDetailsBeanSavePlantStationDetailsData() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		plantStationDetailsDAO.saveAndFlush(plantStationDetailsMapper.mapPlantStationDetails(plantStationDetailsBean));
		Assert.assertEquals(3, plantStationDetailsDAO.count());
	}

	@Test
	public void givenPlantCodeFetchPlantStationDetailsData() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		plantStationDetailsDAO.saveAndFlush(plantStationDetailsMapper.mapPlantStationDetails(plantStationDetailsBean));
		List<PlantStationDetails> plantStationDetailsList = plantStationDetailsDAO.fetchPlantStationDetails("Plant Code");
		Assert.assertEquals(1, plantStationDetailsList.size());
	}

	@Test
	public void givenStationNumberFetchPlantStationId() {
		PlantStationDetailsBean plantStationDetailsBean = PlantStationDetailsBuilder.createPlantStationDetailsBean();
		plantStationDetailsDAO.saveAndFlush(plantStationDetailsMapper.mapPlantStationDetails(plantStationDetailsBean));
		PlantStationDetails plantStationDetails = plantStationDetailsDAO.getOne("47f3553a-1013-43ff-9f2c-fdc11bc09b9f");
		Assert.assertNotNull(plantStationDetails);
	}

}
