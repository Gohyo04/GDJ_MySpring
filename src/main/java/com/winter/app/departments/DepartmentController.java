package com.winter.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		mv.addObject("detail",departmentDTO);
		mv.setViewName("departments/detail");
		return mv;
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<DepartmentDTO> ar =  departmentService.getList();
		model.addAttribute("list",ar);
		
		return "departments/list";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add(DepartmentDTO ddto) throws Exception{
		return "departments/add";
	}
	
	@RequestMapping()
	public ModelAndView add(DepartmentDTO ddto, ModelAndView mv)throws Exception{
		int result = departmentService.add(ddto);
		
		String msg = "추가실패";
		if(result > 0) {
			msg = "추가성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(DepartmentDTO ddto, Model model) throws Exception{
		ddto = departmentService.getDetail(ddto);
		model.addAttribute("dto",ddto);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView update(DepartmentDTO ddto ,ModelAndView mv) throws Exception{
		int result = departmentService.update(ddto);
		
		String msg = "변경실패";
		if(result > 0) {
			msg = "변경성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ModelAndView delete(ModelAndView mv, DepartmentDTO ddto) throws Exception{
		int result = departmentService.delete(ddto);
		
		String msg = "삭제실패";
		if(result > 0) {
			msg = "삭제성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path","./list");
		
		mv.setViewName("commons/result");
		return mv;
	}
}














