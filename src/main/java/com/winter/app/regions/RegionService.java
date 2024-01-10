package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

//DAO 보내기전 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	// 내장 객체중에서 application
	private ServletContext servletContext;	
	
	// list
	public List<RegionDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		Long totalCount = regionDAO.getTotal(pager);

		pager.makeNum(totalCount);
		List<RegionDTO> ar = this.regionDAO.getList(pager);	
		return ar;
	}
	
	// Detail
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception{
		return regionDAO.getDetail(regionDTO);
	}
	
	// Add
	public int add(RegionDTO regionDTO, MultipartFile file) throws Exception{
		int result = regionDAO.add(regionDTO);
		// 1. 어디에 저장할것인가
		String path = servletContext.getRealPath("/resources/upload");
		System.out.println(path);

		File f = new File(path, "regions");
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// 2. 어떤 파일명으로 저장할 것인가?
			// a. 시간 사용
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println("시간 사용 : "+fileName);
			// b. UUID
		fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println("UUID 사용 : "+fileName);
		
		// 3. 파일 저장
		f = new File(f, fileName);
		// a. FileCopyUtils 클래스 사용
		FileCopyUtils.copy(file.getBytes(), f);
		
		// 4. DB에 정보 저장
		RegionFileDTO rfdto = new RegionFileDTO();
		rfdto.setFileName(fileName);
		rfdto.setOriName(file.getOriginalFilename());
		rfdto.setRegion_id(regionDTO.getRegion_id());
		result = regionDAO.addFile(rfdto);
		
		return result;
	}
	
	// Update
	public int update(RegionDTO regionDTO) throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	// Delete
	public int delete(RegionDTO regionDTO) throws Exception{
		return regionDAO.delete(regionDTO);
	}
}
