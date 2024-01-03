package com.gohyo.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gohyo.app.util.DBConnector;

public class ProductDAO {
	
	public List<ProductDTO> getlist() throws Exception {
	Connection con = DBConnector.getConnector();
		String sql="SELECT*FROM PRODUCT";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		while(rs.next()){
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductContents(rs.getString("PRODUCTCONTENRS"));
			productDTO.setProductRate(rs.getDouble("PRODUCTRATE"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
			DBConnector.disConnect(rs, ps, con);
			
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		Connection con = DBConnector.getConnector();
		String sql = "SELECT*FROM PRODUCT WHERE PRODUCTNUM=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, productDTO.getProductNum());
		ResultSet rs = ps.executeQuery();
		ProductDTO resultDTO = null;
		if(rs.next()) {
			resultDTO = new ProductDTO();
			resultDTO.setProductNum(rs.getLong("PRODUCETNUM"));
			resultDTO.setProductName(rs.getString("PRODUCTNAME"));
			resultDTO.setProductContents(rs.getString("PRODUCTCONTENTS"));
			resultDTO.setProductRate(rs.getDouble("PRODUCTRATE"));
			resultDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
		}
		DBConnector.disConnect(rs, ps, con);
		return resultDTO;
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
