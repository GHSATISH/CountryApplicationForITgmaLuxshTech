package com.itgma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itgma.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>{
	
	@Query("from CountryEntity where countryRegion=:region" )
	public List<CountryEntity> getCountriesByRegion(@Param("region") String region);

}
