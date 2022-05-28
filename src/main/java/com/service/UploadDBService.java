package com.service;

import java.io.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadDBService {
	public static String rootPath="D:\\ComputerLanguages\\Spring\\spring-boot\\src\\main\\resources\\static\\";
	
	public boolean profilePicUpload(MultipartFile file,String email) {
//		File rootDir=new File();
		File emailCre=new File(rootPath,email);
		emailCre.mkdir();
		
		File pre=new File(emailCre,file.getOriginalFilename());
		try {
			byte[] b=file.getBytes();
			FileOutputStream wr=new FileOutputStream(pre);
			wr.write(b);
			wr.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
