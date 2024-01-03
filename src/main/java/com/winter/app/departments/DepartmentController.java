package com.winter.app.departments;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/departments/*")
public class DepartmentController {
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception{
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		String id = request.getParameter("department_id");

		departmentDTO.setDepartment_id(Integer.parseInt(id));
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		request.setAttribute("detail", departmentDTO);
		
		return "departments/detail";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception{
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		request.setAttribute("list", ar);
		return "departments/list";
	}
	
}
