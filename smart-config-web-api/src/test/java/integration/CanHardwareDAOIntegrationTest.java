package integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chinmay.it.mfg.Application;
import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.dataBuilders.CanHardwareBuilder;
import com.chinmay.it.mfg.domains.CanHardware;
import com.chinmay.it.mfg.mappers.CanHardwareMapper;
import com.chinmay.it.mfg.repositories.CanHardwareDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CanHardwareDAOIntegrationTest {
	
    @Autowired
    private CanHardwareDAO canHardwareDAO;
    
    @Autowired
    private CanHardwareMapper canHardwareMapper;
    
    @Test
    public void givenCanHardwareBeanSaveCanHardwareData() {
    	CanHardwareBean canHardwareBean = CanHardwareBuilder.createCanHardwareBean();
		canHardwareDAO.saveAndFlush(canHardwareMapper.mapCanHardware(canHardwareBean));
        Assert.assertEquals(2, canHardwareDAO.count());
    }
    
    @Test
    public void givenPlantStationIdFetchCanHardwareData() {
    	CanHardwareBean canHardwareBean = CanHardwareBuilder.createCanHardwareBean();
		canHardwareDAO.saveAndFlush(canHardwareMapper.mapCanHardware(canHardwareBean));
        List<CanHardware> canHardwareList = canHardwareDAO.fetchCanHardware("Plant Station Id");
        Assert.assertEquals(1,canHardwareList.size());
    }
    
    @Test
    public void givenPlantStationIdDeleteCanHardwareData() {
    	CanHardwareBean canHardwareBean = CanHardwareBuilder.createCanHardwareBean();
		canHardwareDAO.saveAndFlush(canHardwareMapper.mapCanHardware(canHardwareBean));
        canHardwareDAO.deleteByPlantStationId("Plant Station Id");
        List<CanHardware> canHardwareList = canHardwareDAO.fetchCanHardware("Plant Station Id");
        Assert.assertEquals(0,canHardwareList.size());
    }
    
}
