package com.gohyo.app.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/products/*")
public class ProductController {
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public Model list(Model model) {
		ProductDAO productDAO = new ProductDAO();
		
		List<ProductDTO> ar = productDAO.getlist();
		model.addAttribute("list", ar);
		
		return model;
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public Model detail(HttpServletRequest request) {
		ProductDAO productDAO = new ProductDAO();
		
		
		return null;
	}
}
