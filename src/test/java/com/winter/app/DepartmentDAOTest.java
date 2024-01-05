package com.winter.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;

public class DepartmentDAOTest extends MyTest{
	
	@Autowired
	private DepartmentDAO departmentDAO; 
	
//	@Test
//	public void getList() throws Exception{
//		List<DepartmentDTO> ar = departmentDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	public void getDetail() {
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		departmentDTO.setDepartment_id(10);
//		
//		assertNotNull(departmentDTO);
//	}
	
//	@Test
//	public void addTest() throws Exception{
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		departmentDTO.setDepartment_id(300);
//		departmentDTO.setDepartment_name("GG11");
//		departmentDTO.setManager_id(200);
//		departmentDTO.setLocation_id(2400);
//		
//		int result = departmentDAO.add(departmentDTO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void updateTest() throws Exception{
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		departmentDTO.setDepartment_id(300);
//		departmentDTO.setDepartment_name("GG22");
//		
//		int result = departmentDAO.update(departmentDTO);
//		
//		assertEquals(1, result);
//	}
	
	
	@Test
	public void deleteTest() throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(290);
		
		int result = departmentDAO.delete(departmentDTO);
		assertEquals(1, result);
	}
	
	
	
	
	
	
	
	
	
	
}
