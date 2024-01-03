package com.winter.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/regions/*")	// default method = get
public class RegionController {
	
	private RegionDAO regionDAO;
	
	public RegionController () {
		this.regionDAO = new RegionDAO();
	}
	
	// 오버로딩
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(RegionDTO regionDTO, Model model) throws Exception{
//		String id = request.getParameter("region_id");
//		String name = request.getParameter("region_name");
//		
//		RegionDTO regionDTO = new RegionDTO();
//		regionDTO.setRegion_id(Integer.parseInt(id));
//		regionDTO.setRegion_name(name);
		
		int result = this.regionDAO.add(regionDTO);
		
		String msg = "등록실패";
		if(result > 0) {
			msg = "등록성공";
		}
		
//		request.setAttribute("msg", msg);
//		request.setAttribute("path", "./list");
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add() {
		
		return "regions/add";
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	// 파라미터의 이름과 타입을 동일하게 (매개변수에)선언
	// 파라미터와 매개변수이름이 다를때 @RequestParam() defaultValue 값이 오지않았을때 넣어줄값 , required = true(값을 무조건 받는다) 
	public String detail(Integer region_id, Model model) throws Exception{
		
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		
		regionDTO.setRegion_id(region_id);
		regionDTO = regionDAO.getDetail(regionDTO);
		
//		request.setAttribute("dto", regionDTO);
		model.addAttribute("dto", regionDTO);
		
		return "regions/detail";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception{
		ModelAndView mv = new ModelAndView();
		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionDAO.getList();
		
//		request.setAttribute("list", ar);
		mv.addObject("list", ar);
		mv.setViewName("regions/list");
		
		return mv;
	}
}
