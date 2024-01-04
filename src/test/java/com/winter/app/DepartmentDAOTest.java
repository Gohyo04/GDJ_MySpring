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
	
	@Test
	public void getList() throws Exception{
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetail() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(10);
		
		assertNotNull(departmentDTO);
	}
}
