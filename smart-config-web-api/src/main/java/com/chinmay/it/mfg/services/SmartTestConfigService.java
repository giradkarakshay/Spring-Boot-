package com.chinmay.it.mfg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinmay.it.mfg.bean.CanHardwareBean;
import com.chinmay.it.mfg.bean.ConfigSettingBean;
import com.chinmay.it.mfg.bean.JdTesterHardwareBean;
import com.chinmay.it.mfg.bean.PlantStationDetailsBean;
import com.chinmay.it.mfg.mappers.CanHardwareMapper;
import com.chinmay.it.mfg.mappers.ConfigSettingMapper;
import com.chinmay.it.mfg.mappers.JdTesterHardwareMapper;
import com.chinmay.it.mfg.mappers.PlantStationDetailsMapper;
import com.chinmay.it.mfg.repositories.CanHardwareDAO;
import com.chinmay.it.mfg.repositories.ConfigSettingDAO;
import com.chinmay.it.mfg.repositories.JdTesterHardwareDAO;
import com.chinmay.it.mfg.repositories.PlantStationDetailsDAO;

@Service
@Transactional
public class SmartTestConfigService {

    private CanHardwareDAO canHardwareDAO;
    private ConfigSettingDAO configSettingDAO;
    private JdTesterHardwareDAO jdTesterHardwareDAO;
    private PlantStationDetailsDAO plantStationDetailsDAO;

    private CanHardwareMapper canHardwareMapper;
    private ConfigSettingMapper configSettingMapper;
    private JdTesterHardwareMapper jdTesterHardwareMapper;
    private PlantStationDetailsMapper plantStationDetailsMapper;

    @Autowired
    public SmartTestConfigService(CanHardwareDAO canHardwareDAO, CanHardwareMapper canHardwareMapper,
                                  ConfigSettingDAO configSettingDAO, ConfigSettingMapper configSettingMapper,
                                  JdTesterHardwareDAO jdTesterHardwareDAO, JdTesterHardwareMapper jdTesterHardwareMapper,
                                  PlantStationDetailsDAO plantStationDetailsDAO, PlantStationDetailsMapper plantStationDetailsMapper) {
        this.canHardwareDAO = canHardwareDAO;
        this.configSettingDAO = configSettingDAO;
        this.jdTesterHardwareDAO = jdTesterHardwareDAO;
        this.plantStationDetailsDAO = plantStationDetailsDAO;

        this.canHardwareMapper = canHardwareMapper;
        this.configSettingMapper = configSettingMapper;
        this.jdTesterHardwareMapper = jdTesterHardwareMapper;
        this.plantStationDetailsMapper = plantStationDetailsMapper;
    }
    
    public List<PlantStationDetailsBean> fetchPlantStationDetails(String unitCode) {
        return plantStationDetailsMapper.mapPlantStationDetailsBeanList(plantStationDetailsDAO.fetchPlantStationDetails(unitCode));
    }

    public PlantStationDetailsBean fetchPlantStationId(String id) {
        return plantStationDetailsMapper.mapPlantStationDetailsBean(plantStationDetailsDAO.getOne(id));
    }

    public List<CanHardwareBean> fetchCanHardware(String plantStationId) {
        return canHardwareMapper.mapCanHardwareBeanList(canHardwareDAO.fetchCanHardware(plantStationId));
    }

    public List<ConfigSettingBean> fetchConfigSetting(String plantStationId) {
        return configSettingMapper.mapConfigSettingBeanList(configSettingDAO.fetchConfigSetting(plantStationId));
    }

    public List<JdTesterHardwareBean> fetchJdTesterHardware(String plantStationId) {
        return jdTesterHardwareMapper.mapJdTesterHardwareBeanList(jdTesterHardwareDAO.fetchJdTesterHardware(plantStationId));
    }
    
    public PlantStationDetailsBean savePlantStationDetails(PlantStationDetailsBean plantStationDetailsBean) {
    	return plantStationDetailsMapper.mapPlantStationDetailsBean(plantStationDetailsDAO.saveAndFlush(plantStationDetailsMapper.mapPlantStationDetails(plantStationDetailsBean)));
    }

    public boolean saveCanHardwareList(List<CanHardwareBean> canHardwareBeanList) {
		return null != canHardwareDAO.save(canHardwareMapper.mapCanHardwareList(canHardwareBeanList)) ? true : false;
    }

    public boolean saveConfigSettingList(List<ConfigSettingBean> configSettingBeanList) {
        return null != configSettingDAO.save(configSettingMapper.mapCanHardwareList(configSettingBeanList)) ? true : false;
    }

    public boolean saveJdTesterHardwareList(List<JdTesterHardwareBean> jdTesterHardwareBeanList) {
        return null != jdTesterHardwareDAO.save(jdTesterHardwareMapper.mapJdTesterHardwareList(jdTesterHardwareBeanList)) ? true : false;
    }

    public boolean deleteWorkStationDetails(String id) {
        canHardwareDAO.deleteByPlantStationId(id);
        configSettingDAO.deleteByPlantStationId(id);
        jdTesterHardwareDAO.deleteByPlantStationId(id);
        plantStationDetailsDAO.delete(id);
        return true;
    }
    
    public boolean deleteCanHardware(String id) {
        canHardwareDAO.delete(id);
        return true;
    }
    
    public boolean deleteConfigSetting(String id) {
        configSettingDAO.delete(id);
        return true;
    }
    
    public boolean deleteJdTesterHardware(String id) {
        jdTesterHardwareDAO.delete(id);
        return true;
    }
}
