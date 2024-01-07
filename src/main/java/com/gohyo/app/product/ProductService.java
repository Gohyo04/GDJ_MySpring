package com.gohyo.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList() {
		return productDAO.getlist();
	}
	
	public ProductDTO getDetail(ProductDTO pdto) {
		return productDAO.getDetail(pdto);
	}
}
