package com.itgma;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.itgma.entity.CountryEntity;
import com.itgma.repository.CountryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class CountryApplicationForITgmaApplicationTests {

//		@Test
//		void contextLoads() {
//		}
	private MockMvc mvc;
  
	private CountryEntity countryEntity;
	
	@Autowired
	CountryRepository countryRepo;

	@Test
	@Order(1)
	public void testCreate() {

		CountryEntity coun = new CountryEntity();
		coun.setId(31L);
		coun.setCountryName("Satish");
		coun.setCountryCapital("Kushwah");
		coun.setCountryRegion("Bengaluru");
		coun.setDefaultCurencyCode("Rupees");
		coun.setDefaultCurencyName("paisa");
		coun.setDefaultCurencySymbol("$");
		coun.setDefaultLanguagesName("Hindi");
		countryRepo.save(coun);
		assertNotNull(countryRepo.findById(4L).get());
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<CountryEntity> findAll = countryRepo.findAll();
		assertThat(findAll).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleData() {
		CountryEntity countrySingle = countryRepo.findById(4L).get();
		assertEquals("India", countrySingle.getCountryName());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		CountryEntity countrUpdate = countryRepo.findById(4L).get();
		countrUpdate.setDefaultLanguagesName("Bengali");
		countryRepo.save(countrUpdate);
		assertNotEquals("Hindi", countryRepo.findById(4L).get().getDefaultLanguagesName());
	}

	@Test
	@Order(5)
	public void testDelete() {
	countryRepo.deleteById(5L); // Put the any value between 1L to 30L
	assertThat(countryRepo.existsById(5L)).isFalse();
	//assertEquals(1L,countryEntity.getId());
		
			}

}
