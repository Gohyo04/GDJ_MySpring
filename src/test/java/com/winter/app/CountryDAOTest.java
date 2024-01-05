package com.winter.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.countries.CountryDAO;
import com.winter.app.countries.CountryDTO;

public class CountryDAOTest extends MyTest{
	
	@Autowired 
	private CountryDAO countryDAO;
	
	@Test
	public void selectListTest() throws Exception{
		CountryDTO countryDTO = new CountryDTO();
		List<CountryDTO> ar = countryDAO.getList();
		
		assertEquals(27, ar.size());
	}
	
//	@Test
//	public void selectOneTest() throws Exception{
//		CountryDTO countryDTO = new CountryDTO();
//		countryDTO.setCountry_id("BE");
//		countryDTO = countryDAO.getCountry(countryDTO);
//		
//		assertNotNull(countryDTO);
//	}
}
