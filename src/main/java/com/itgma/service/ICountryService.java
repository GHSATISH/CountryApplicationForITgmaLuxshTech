package com.itgma.service;

import java.util.List;
import java.util.Map;

import com.itgma.entity.CountryEntity;

public interface ICountryService {
	
	   //Countries list end point
		List<CountryEntity> getAllCountries();
		
		// Countries filter based on region end point
		public List<CountryEntity> getCountriesByRegion(String countryRegion);
		
		// Total number of countries for each region end point
		public Map<String, Integer> getRegionTotals();
		
		
       //-----------------------------------------------------------------
		
		
		// CRUD API for favorite countries end point
		public CountryEntity createFavourite(CountryEntity country);
		
		public List<CountryEntity> getFavourites();
		
		public CountryEntity updateFavourite(CountryEntity country, long id);
		
		public void deleteFavourite(long id);

}
