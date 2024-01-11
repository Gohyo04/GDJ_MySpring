package com.winter.app.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

// 파일 업로드관련
@Component
public class FileManager {
	
	// 파일 삭제
	public boolean fileDelete(String path, String fileName) throws Exception{
		File f = new File(path,fileName);
		return f.delete();
	}
	
	
	// 파일저장
	public String fileSave(String path, MultipartFile file) throws Exception{
		System.out.println(path);
		
		// path : realpath
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception();
			//return;
		}
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		// 2. 어떤 파일명으로 저장할 것인가?
			// a. 시간 사용
		Calendar ca = Calendar.getInstance();
		String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println("시간 사용 : "+fileName);
			// b. UUID
//		fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
//		System.out.println("UUID 사용 : "+fileName);

		f = new File(f, fileName);
		
//		3. 파일 저장
//		a. FileCopyUtils 클래스 사용
//		FileCopyUtils.copy(file.getBytes(), f);
		
//		b. MultipartFile의  transferTo 메서드
		file.transferTo(f);
		
		return fileName;
	}
}
















