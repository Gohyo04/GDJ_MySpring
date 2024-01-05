package com.winter.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/regions/*")	// default method = get
public class RegionController {
	
	@Autowired
	private RegionService  regionService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<RegionDTO> ar = regionService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("regions/list");
		
		return mv;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView detail(RegionDTO regionDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		regionDTO = regionService.getDetail(regionDTO);
		
		mv.addObject("dto",regionDTO);
		mv.setViewName("regions/detail");
		
		return mv;
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() {
		return "regions/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView add(RegionDTO regionDTO, ModelAndView mv) throws Exception{
		int result = regionService.add(regionDTO);
		
		String msg = "등록실패";
		if(result > 0) {
			msg = "등록성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path", "./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
}
