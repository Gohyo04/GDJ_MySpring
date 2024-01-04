package com.winter.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;

public class RegionDAOTest extends MyTest{
	@Autowired 
	private RegionDAO regionDAO;
	
	@Test
	public void getDetailTest() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(1);
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
	}
	
	@Test
	public void getList() throws Exception {
		List<RegionDTO> ar = regionDAO.getList();
		
		assertEquals(11, ar.size());
	}
}
