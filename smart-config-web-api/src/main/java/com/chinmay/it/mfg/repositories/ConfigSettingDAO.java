package com.chinmay.it.mfg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chinmay.it.mfg.domains.ConfigSetting;

@Transactional
@Repository
public interface ConfigSettingDAO extends JpaRepository<ConfigSetting, String> {

	@Query("SELECT ut FROM ConfigSetting ut WHERE ut.plantStationId= :plantStationId")
	public List<ConfigSetting> fetchConfigSetting(@Param("plantStationId") String plantStationId);

	@Modifying
	@Query("DELETE FROM ConfigSetting ut WHERE ut.plantStationId= :id")
	public void deleteByPlantStationId(@Param("id") String id);

}
