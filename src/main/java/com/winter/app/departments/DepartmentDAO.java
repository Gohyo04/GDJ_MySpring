package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnector;

@Repository
public class DepartmentDAO {
	// DAO -> Data Access Object
	// SELECT Detail
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.winter.app.departments.DepartmentDAO.";
	
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail", departmentDTO); 
	}
	
	// SELECT List
	public List<DepartmentDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	
	// Insert
	public int add(DepartmentDTO ddto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "INSERT INTO DEPARTMENTS VALUES (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ddto.getDepartment_id());
		ps.setString(2, ddto.getDepartment_name());
		ps.setInt(3, ddto.getManager_id());
		ps.setInt(4, ddto.getLocation_id());
		
		int result = ps.executeUpdate();
		DBConnector.disConnect(ps, con);
		return result;
	}
	
	
	public int update(DepartmentDTO ddto) throws Exception{
		Connection con = DBConnector.getConnector();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ddto.getDepartment_name());
		ps.setInt(2, ddto.getManager_id());
		ps.setInt(3, ddto.getLocation_id());
		ps.setInt(4, ddto.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
	}
}
