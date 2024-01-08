package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.getDetail(departmentDTO);
	}
	
	public List<DepartmentDTO> getList() throws Exception{
		return this.departmentDAO.getList();
	}
	
	public int add(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.add(departmentDTO);
	}
	
	public int update(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.update(departmentDTO);
	}
	
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		return departmentDAO.delete(departmentDTO);
	}
}
