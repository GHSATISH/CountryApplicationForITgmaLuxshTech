package com.itgma.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itgma.entity.CountryEntity;
import com.itgma.service.ICountryService;


@RestController
public class CountryController {
	
	@Autowired
	private ICountryService countryService;
	
	
	// Countries list end point
	@GetMapping("/countries")
	public ResponseEntity<List<CountryEntity>> getCountries() {
	  List<CountryEntity> countries = countryService.getAllCountries();
	  return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	// Countries filter based on region end point	
	@GetMapping("/countries/region/{countryRegion}")
	public ResponseEntity<List<CountryEntity>> getCountriesByRegion(@PathVariable("countryRegion") String countryRegion) {
	  List<CountryEntity> countries = countryService.getCountriesByRegion(countryRegion);
	  return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	
	// Total number of countries for each region end point	
	@GetMapping("/countries/regions/totals")
	public ResponseEntity<Map<String, Integer>> getRegionTotals() {
	  Map<String, Integer> regionTotals = countryService.getRegionTotals();
	  return new ResponseEntity<>(regionTotals, HttpStatus.OK);
	}
		
	// CRUD API for favorite countries end point	
	@PostMapping("/favourites/create")
	public ResponseEntity<String> createFavourite(@RequestBody CountryEntity country) {
	  countryService.createFavourite(country);
	  return new ResponseEntity<>("Favourite created successfully", HttpStatus.OK);
	}

	@GetMapping("/favourites")
	public ResponseEntity<List<CountryEntity>> getFavourites() {
	  List<CountryEntity> favourites = countryService.getFavourites();
	  return new ResponseEntity<>(favourites, HttpStatus.OK);
	}

	@PutMapping("/favourites/update/{id}")
	public ResponseEntity<String> updateFavourite(@RequestBody CountryEntity country, @PathVariable("id") long id) {
		CountryEntity updateFavourite = countryService.updateFavourite(country, id);
	  return new ResponseEntity<>("Favourite updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/favourites/delete/{id}")
	public ResponseEntity<String> deleteFavourite(@PathVariable("id") long id) {
	  countryService.deleteFavourite(id);
	  return new ResponseEntity<>("Favourite deleted successfully", HttpStatus.OK);
	}
}