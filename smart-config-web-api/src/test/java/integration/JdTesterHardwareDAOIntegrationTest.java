package integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinmay.it.mfg.Application;
import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.dataBuilders.JdTesterHardwareBuilder;
import com.chinmay.it.mfg.domains.JdTesterHardware;
import com.chinmay.it.mfg.mappers.JdTesterHardwareMapper;
import com.chinmay.it.mfg.repositories.JdTesterHardwareDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JdTesterHardwareDAOIntegrationTest {

	@Autowired
	private JdTesterHardwareDAO jdTesterHardwareDAO;

	@Autowired
	private JdTesterHardwareMapper jdTesterHardwareMapper;

	@Test
	public void givenJdTesterHardwareBeanSaveJdTesterHardwareData() {
		JdTesterHardwareBean jdTesterHardwareBean = JdTesterHardwareBuilder.createJdTesterHardwareBean();
		jdTesterHardwareDAO.saveAndFlush(jdTesterHardwareMapper.mapJdTesterHardware(jdTesterHardwareBean));
		Assert.assertEquals(1, jdTesterHardwareDAO.count());
	}

	@Test
	public void givenPlantStationIdFetchJdTesterHardwareData() {
		JdTesterHardwareBean jdTesterHardwareBean = JdTesterHardwareBuilder.createJdTesterHardwareBean();
		jdTesterHardwareDAO.saveAndFlush(jdTesterHardwareMapper.mapJdTesterHardware(jdTesterHardwareBean));
		List<JdTesterHardware> jdTesterHardwareList = jdTesterHardwareDAO.fetchJdTesterHardware("Plant Station Id");
		Assert.assertEquals(1, jdTesterHardwareList.size());
	}

	@Test
	public void givenPlantStationIdDeleteJdTesterHardwareData() {
		JdTesterHardwareBean jdTesterHardwareBean = JdTesterHardwareBuilder.createJdTesterHardwareBean();
		jdTesterHardwareDAO.saveAndFlush(jdTesterHardwareMapper.mapJdTesterHardware(jdTesterHardwareBean));
		jdTesterHardwareDAO.deleteByPlantStationId("Plant Station Id");
		List<JdTesterHardware> jdTesterHardwareList = jdTesterHardwareDAO.fetchJdTesterHardware("Plant Station Id");
		Assert.assertEquals(0, jdTesterHardwareList.size());
	}

}
