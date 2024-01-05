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
		return sqlSession.insert(namespace+"add", ddto);
	}
	
	
	public int update(DepartmentDTO ddto) throws Exception{
		return sqlSession.update(namespace+"update", ddto);
	}
	
	public int delete(DepartmentDTO ddto) throws Exception{
		return sqlSession.delete(namespace+"delete",ddto);
	}
}
