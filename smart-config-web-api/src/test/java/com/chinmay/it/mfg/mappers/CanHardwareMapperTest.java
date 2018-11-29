package com.chinmay.it.mfg.mappers;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.dataBuilders.CanHardwareBuilder;
import com.chinmay.it.mfg.domains.CanHardware;
import com.chinmay.it.mfg.mappers.CanHardwareMapper;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sk03644 on 03-Aug-18.
 */
public class CanHardwareMapperTest {
    CanHardwareMapper canHardwareMapper;
    @Before
    public void init() { canHardwareMapper = new CanHardwareMapper(); }
    @Test
    public void whenCanHardwareBeanProvided_mapToCanHardwareDomain(){
        CanHardwareBean canHardwareBean = CanHardwareBuilder.createCanHardwareBean();
        CanHardware canHardware = canHardwareMapper.mapCanHardware(canHardwareBean);

        assertEquals(canHardwareBean.getAliasName(),canHardware.getAliasName());
        assertEquals(canHardwareBean.getCanDevice(), canHardware.getCanDevice());
        assertEquals(canHardwareBean.getChannelName(),canHardware.getChannelName());
        assertEquals(canHardwareBean.getChannelIndex(), canHardware.getChannelIndex());
        assertEquals(canHardwareBean.getHardwareIndex(),canHardware.getHardwareIndex());
        assertEquals(canHardwareBean.getHardwareType(), canHardware.getHardwareType());
        assertEquals(canHardwareBean.getPlantStationId(),canHardware.getPlantStationId());
    }

    @Test
    public void whenCanHardwareListProvided_mapToCanHardwareBeanList(){
        List<CanHardware> canHardwareList = CanHardwareBuilder.createCanHardwareList();
        List<CanHardwareBean> canHardwareBeanList = canHardwareMapper.mapCanHardwareBeanList(canHardwareList);

        assertEquals(canHardwareList.size(),canHardwareBeanList.size());
    }
}
