package com.winter.app.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class RegionDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.winter.app.regions.RegionDAO.";
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);
	}
	
	public List<RegionDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");	 
	}
	
	// Insert
	public int add(RegionDTO rdto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO REGIONS VALUES (?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, rdto.getRegion_id());
		ps.setString(2, rdto.getRegion_name());
		
		// 성공 1, 실패 0 or error
		int result =  ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	// Update
	public int update(RegionDTO regionDTO) throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?"; 
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, regionDTO.getRegion_name());
		ps.setInt(2, regionDTO.getRegion_id());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
