package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() {
		return productDAO.getlist();
	}
}
