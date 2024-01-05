package com.winter.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class CountryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.winter.app.countries.CountryDAO.";
	
	// 하나씩 가져오기 (select)
	public CountryDTO getCountry(CountryDTO countryDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getCountry");
	}
	
	// 여러개 가져오기 (select)
	public List<CountryDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	
	// 추가하기 ( insert )
	public int add(CountryDTO cdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO COUNTRIES VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getCountry_id());
		ps.setString(2, cdto.getCountry_name());
		ps.setInt(3, cdto.getRegion_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	// 수정하기 ( update )
	public int update(CountryDTO cdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cdto.getCountry_name());
		ps.setInt(2, cdto.getRegion_id());
		ps.setString(3, cdto.getCountry_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
}
