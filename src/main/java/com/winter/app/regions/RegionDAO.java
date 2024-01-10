package com.winter.app.regions;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class RegionDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.winter.app.regions.RegionDAO.";
	
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);
	}
	
	public List<RegionDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(namespace+"getList", pager);	 
	}
	
	public int addFile(RegionFileDTO regionFileDTO) throws Exception{
		return sqlSession.insert(namespace+"addFile", regionFileDTO);
	}
	
	// Insert
	public int add(RegionDTO rdto) throws Exception{
		
		return sqlSession.insert(namespace+"add",rdto);
	}
	
	// Update
	public int update(RegionDTO regionDTO) throws Exception {
		return sqlSession.update(namespace+"update",regionDTO);
	}
	
	// Count
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(namespace+"getTotal", pager);
	}
	
	// Delete
	public int delete(RegionDTO regionDTO) throws Exception{
		return sqlSession.delete(namespace+"delete",regionDTO);
	}
	
}
