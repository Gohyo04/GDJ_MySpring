package com.winter.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.regions.RegionDAO;
import com.winter.app.regions.RegionDTO;
import com.winter.app.util.Pager;

public class RegionDAOTest extends MyTest{
	@Autowired 
	private RegionDAO regionDAO;
	
//	@Test
//	public void getDetailTest() throws Exception{
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(1);
//		regionDTO = regionDAO.getDetail(regionDTO);
//		
//		assertNotNull(regionDTO);
//	}
	
	@Test
	public void getList() throws Exception {
		Pager pager = new Pager();
		pager.setPage(2L);
		pager.makeRow();
		
		List<RegionDTO> ar = regionDAO.getList(pager);
		System.out.println(ar.get(0).getRegion_id());
		assertEquals(10, ar.size());
	}
	
//	@Test
//	public void addTest() throws Exception{
//		RegionDTO rdto = new RegionDTO();
//		
//		for(int i=0;i<100;i++) {
//			rdto.setRegion_name("Test"+i);
//			int result = regionDAO.add(rdto);
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//		}
//		System.out.println("100개 입력 완료");
		//assertEquals(1, result);
//	}
	
//	@Test
//	public void updateTest() throws Exception{
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(208);
//		regionDTO.setRegion_name("Test");
//		int result = regionDAO.update(regionDTO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void deleteTest() throws Exception{
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(209);
//		
//		int result = regionDAO.delete(regionDTO);
//		
//		assertEquals(1,result);
//	}
	
}
