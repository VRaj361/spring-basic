package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserFileBean;
import com.dao.FileDBDao;
import com.service.UploadDBService;

@Controller
public class FileDBController {
	
	
	@Autowired
	UploadDBService uploadService;
	
	
	@Autowired
	FileDBDao dao;
	
	
	
	@GetMapping("/fileuploaddb")
	public String fileUploadDB(Model model) {
		UserFileBean filedb=new UserFileBean();
		model.addAttribute("filedb",filedb);
		return "FileUploadDB";
	}
	
	@PostMapping("/saveuserdb")
	public String saveUser(@ModelAttribute("filedb") @Valid UserFileBean bean,BindingResult bind,Model model,@RequestParam("profilepic") MultipartFile file) {//insert user in database if error then return on the FileUploadDB
		System.out.println(bean.getEmail());
		System.out.println(bean.getName());
		System.out.println(bean.getPassword());
		System.out.println("file "+bean.getProfileurl());
		System.out.println(file.getOriginalFilename());
//		bean.setProfileurl(file.getOriginalFilename());
		model.addAttribute("filedb",bean);
		System.out.println(bind.getErrorCount());
		
		if(bind.hasErrors()||file.getOriginalFilename()=="") {
			model.addAttribute("fileerror","Please Select the File");
			return "FileUploadDB";
		}else {
			boolean upload=uploadService.profilePicUpload(file,bean.getEmail());
			if(upload) {
				bean.setProfileurl(bean.getEmail()+"/"+file.getOriginalFilename());
				dao.insertUser(bean);
			}else {
				System.out.println("failed");
			}
			return "SuccessFile";
		}
	}
	
	
	
}
