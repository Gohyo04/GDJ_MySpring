package com.gohyo.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) {
		List<ProductDTO> ar = productService.getList();
		mv.addObject("list", ar);
		mv.setViewName("products/list");
		return mv;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView detail(ProductDTO pdto, ModelAndView mv) {
		pdto = productService.getDetail(pdto);
		
		mv.addObject("dto",pdto);
		mv.setViewName("product/detail");
		return mv;
	}
}
