package com.winter.app.departments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/departments/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView detail(DepartmentDTO departmentDTO, ModelAndView mv) throws Exception{
		departmentDTO = departmentService.getDetail(departmentDTO);
		
		mv.addObject("dto",departmentDTO);
		mv.setViewName("departments/detail");
		return mv;
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception{
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentDTO> ar = departmentDAO.getList();
		
		request.setAttribute("list", ar);
		return "departments/list";
	}
}
