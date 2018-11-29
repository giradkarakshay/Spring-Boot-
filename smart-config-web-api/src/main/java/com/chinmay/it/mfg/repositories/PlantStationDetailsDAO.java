package com.chinmay.it.mfg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chinmay.it.mfg.domains.PlantStationDetails;

@Transactional
@Repository
public interface PlantStationDetailsDAO extends JpaRepository<PlantStationDetails, String> {

	@Query("SELECT ut FROM PlantStationDetails ut WHERE ut.plantCode= :unitCode")
	public List<PlantStationDetails> fetchPlantStationDetails(@Param("unitCode") String unitCode);

}
