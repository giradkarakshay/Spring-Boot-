package com.chinmay.it.mfg.mappers;

import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.dataBuilders.JdTesterHardwareBuilder;
import com.chinmay.it.mfg.domains.JdTesterHardware;
import com.chinmay.it.mfg.mappers.JdTesterHardwareMapper;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sk03644 on 03-Aug-18.
 */
public class JdTesterHardwareMapperTest {
    JdTesterHardwareMapper jdTesterHardwareMapper;
    @Before
    public void init() { jdTesterHardwareMapper = new JdTesterHardwareMapper(); }
    @Test
    public void whenJdTesterHardwareBeanProvided_mapJdTesterHardwareDomain() {
        JdTesterHardwareBean jdTesterHardwareBean = JdTesterHardwareBuilder.createJdTesterHardwareBean();
        JdTesterHardware jdTesterHardware = jdTesterHardwareMapper.mapJdTesterHardware(jdTesterHardwareBean);

        assertEquals(jdTesterHardwareBean.getBitOffset(),jdTesterHardware.getBitOffset());
        assertEquals(jdTesterHardwareBean.getBlockOffset(),jdTesterHardware.getBlockOffset());
        assertEquals(jdTesterHardwareBean.getBulkHeadPin(),jdTesterHardware.getBulkHeadPin());
        assertEquals(jdTesterHardwareBean.getConnector(),jdTesterHardware.getConnector());
        assertEquals(jdTesterHardwareBean.getDescription(),jdTesterHardware.getDescription());
        assertEquals(jdTesterHardwareBean.getFelxBoxPin(),jdTesterHardware.getFelxBoxPin());
        assertEquals(jdTesterHardwareBean.getFusesRelays(),jdTesterHardware.getFusesRelays());
        assertEquals(jdTesterHardwareBean.getId(),jdTesterHardware.getId());
        assertEquals(jdTesterHardwareBean.getHardwareName(),jdTesterHardware.getHardwareName());
        assertEquals(jdTesterHardwareBean.getPlantStationId(),jdTesterHardware.getPlantStationId());
        assertEquals(jdTesterHardwareBean.getPullUp(),jdTesterHardware.getPullUp());
        assertEquals(jdTesterHardwareBean.getPwm(),jdTesterHardware.getPwm());
        assertEquals(jdTesterHardwareBean.getRawMaximum(),jdTesterHardware.getRawMaximum());
        assertEquals(jdTesterHardwareBean.getRawMinimum(),jdTesterHardware.getRawMinimum());
        assertEquals(jdTesterHardwareBean.getScaledMaximum(),jdTesterHardware.getScaledMaximum());
        assertEquals(jdTesterHardwareBean.getScaledMinimum(),jdTesterHardware.getScaledMinimum());
        assertEquals(jdTesterHardwareBean.getScalingFactor(),jdTesterHardware.getScalingFactor());
        assertEquals(jdTesterHardwareBean.getScalingOffset(),jdTesterHardware.getScalingOffset());
        assertEquals(jdTesterHardwareBean.getTla(),jdTesterHardware.getTla());
        assertEquals(jdTesterHardwareBean.getTypeCode(),jdTesterHardware.getTypeCode());
        assertEquals(jdTesterHardwareBean.getUm(),jdTesterHardware.getUm());
    }

    @Test
    public void whenJdTesterHardwareListProvided_mapToJdTesterHardwareBeanList(){
        List<JdTesterHardware> jdTesterHardwareList = JdTesterHardwareBuilder.createJdTesterHardwareList();
        List<JdTesterHardwareBean> jdTesterHardwareBeanList = jdTesterHardwareMapper.mapJdTesterHardwareBeanList(jdTesterHardwareList);

        assertEquals(jdTesterHardwareList.size(),jdTesterHardwareBeanList.size());
    }
}
