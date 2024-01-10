package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

@Controller
@RequestMapping(value="/regions/*")	// default method = get
public class RegionController {
	
	@Autowired
	private RegionService  regionService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<RegionDTO> ar = regionService.getList(pager);
		
		mv.addObject("pager",pager);
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
	public ModelAndView add(RegionDTO regionDTO, ModelAndView mv, MultipartFile photo) throws Exception{
		int result = regionService.add(regionDTO, photo);

		String msg = "등록실패";
		if(result > 0) {
			msg = "등록성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path", "./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(RegionDTO regionDTO, Model model) throws Exception{
		regionDTO = regionService.getDetail(regionDTO);
		model.addAttribute("dto",regionDTO);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO, ModelAndView mv) throws Exception{
		int result = regionService.update(regionDTO);
		
		String msg = "변경실패";
		if(result > 0) {
			msg = "변경성공";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("path","./list");
		mv.setViewName("commons/result");
		
		return mv;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public ModelAndView delete(RegionDTO regionDTO, ModelAndView mv) throws Exception{
		// 결과 성공/실패 여부
		int result = regionService.delete(regionDTO);
		
		// 결과를 어떻게 반환할지
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
