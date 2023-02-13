package com.itgma.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itgma.entity.CountryEntity;
import com.itgma.repository.CountryRepository;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private CountryRepository countryRepo;

	// -----------------------------------------------

	@Override
	public List<CountryEntity> getAllCountries() {
		List<CountryEntity> findAll = countryRepo.findAll();
		return findAll;
	}

	// -----------------------------------------------

	@Override
	public List<CountryEntity> getCountriesByRegion(String countryRegion) {
		return countryRepo.getCountriesByRegion(countryRegion);
	}

	// -----------------------------------------------

	@Override
	public Map<String, Integer> getRegionTotals() {

		List<CountryEntity> countries = countryRepo.findAll();
		Map<String, Integer> regionTotals = new HashMap<>();
		for (CountryEntity country : countries) {
			String region = country.getCountryRegion();
			int currentCount = regionTotals.getOrDefault(region, 0);
			regionTotals.put(region, currentCount + 1);
		}
		return regionTotals;
	}

	// #######################################################

	@Override
	public CountryEntity createFavourite(CountryEntity country) {
		CountryEntity create = countryRepo.save(country);
		return create;
	}

	@Override
	public List<CountryEntity> getFavourites() {
		List<CountryEntity> findAll = countryRepo.findAll();
		return findAll;
	}

	@Override
	public CountryEntity updateFavourite(CountryEntity country, long id) {

		CountryEntity coun = countryRepo.getById(id);
		coun.setCountryName(country.getCountryName());
		coun.setCountryCapital(country.getCountryCapital());
		coun.setCountryRegion(country.getCountryRegion());
		coun.setDefaultCurencyCode(country.getDefaultCurencyCode());
		coun.setDefaultCurencyName(country.getDefaultCurencyName());
		coun.setDefaultCurencySymbol(country.getDefaultCurencySymbol());
		coun.setDefaultLanguagesName(country.getDefaultLanguagesName());
		
		return countryRepo.save(coun);
	}

	@Override
	public void deleteFavourite(long id) {
		countryRepo.deleteById(id);
	}
}
