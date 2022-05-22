package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@GetMapping("/fileupload")
	public String fileUpload() {
		return "FileUpload";
	}

	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profileurl") MultipartFile file,@RequestParam("title") String title) throws IOException {
		
		System.out.println(file.getOriginalFilename());
		
		File stadir=new File("D:\\ComputerLanguages\\Spring\\spring-boot\\src\\main\\resources\\static\\");
		File f=new File(stadir,file.getOriginalFilename());
		
		
		try {
			byte[] b=file.getBytes();
			FileOutputStream fo=new FileOutputStream(f);
			fo.write(b);
			fo.close();
		}catch (Exception e) {
			System.out.println("in");
			e.printStackTrace();
		}
		
		return "SuccessFile";
		
	}
	
	@GetMapping("/listfilesupload")
	public String listFileUpload(Model model) {
		File f=new File("D:\\ComputerLanguages\\Spring\\spring-boot\\src\\main\\resources\\static\\");
		String allFiles[]=f.list();
		model.addAttribute("files",allFiles);
		return "ListFilesUpload";
		
	}
	
	@GetMapping("/viewImage")
	public String viewimage(@RequestParam("image") String str, Model model) {
		model.addAttribute("image",str);
		return "viewImage";
	}
	

}
