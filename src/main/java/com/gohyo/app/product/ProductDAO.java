package com.gohyo.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.gohyo.app.product.ProductDAO.";
	
	public List<ProductDTO> getlist() {
		return sqlSession.selectList(namespace+"getList");
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) {
		
		return null;
	}
		
	public int doAdd(ProductDTO productDTO) {
		
		return 0;
	}
	
	public int doUpdate(ProductDTO productDTO) {
		
		return 0;
	}
	
	public int doDelete(ProductDTO productDTO) {
		
		return 0;
	}

	
}
