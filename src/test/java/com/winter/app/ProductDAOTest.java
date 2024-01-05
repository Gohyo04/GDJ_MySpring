package com.winter.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gohyo.app.product.ProductDAO;
import com.gohyo.app.product.ProductDTO;

public class ProductDAOTest extends MyTest{

	@Autowired
	private ProductDAO productDAO;
	
	public void getListTest() {
		List<ProductDTO> ar = productDAO.getlist();
		
		assertEquals(2, ar.size());
	}
}
