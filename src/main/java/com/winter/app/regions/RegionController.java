package com.winter.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
