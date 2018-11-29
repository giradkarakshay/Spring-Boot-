package com.chinmay.it.mfg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chinmay.it.mfg.domains.CanHardware;

@Transactional
@Repository
public interface CanHardwareDAO extends JpaRepository<CanHardware, String> {

	@Query("SELECT ut FROM CanHardware ut WHERE ut.plantStationId= :plantStationId")
	public List<CanHardware> fetchCanHardware(@Param("plantStationId") String plantStationId);

	@Modifying
	@Query("DELETE FROM CanHardware ut WHERE ut.plantStationId= :id")
	public void deleteByPlantStationId(@Param("id") String id);

}
