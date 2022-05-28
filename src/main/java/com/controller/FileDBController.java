package com.controller;

import java.util.List;

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
		UserFileBean filedb = new UserFileBean();
		model.addAttribute("filedb", filedb);
		return "FileUploadDB";
	}

	@PostMapping("/saveuserdb")
	public String saveUser(@ModelAttribute("filedb") @Valid UserFileBean bean, BindingResult bind, Model model) {// insert
																								// FileUploadDB

//		bean.setProfileurl(file.getOriginalFilename());
		model.addAttribute("filedb", bean);
		System.out.println(bind.getErrorCount());
		System.out.println(bean.getProfilePic().isEmpty());
		if (bind.hasErrors()) {
			return "FileUploadDB";
		}
		else if (bean.getProfilePic().isEmpty()) {
			model.addAttribute("fileerror", "Please Select the File");
			return "FileUploadDB";

		} else {
			MultipartFile file = bean.getProfilePic();
			System.out.println(bean.getEmail());
			System.out.println(bean.getName());
			System.out.println(bean.getPassword());
			System.out.println("file " + bean.getProfileurl());
			System.out.println(file.getOriginalFilename());
			boolean upload = uploadService.profilePicUpload(file, bean.getEmail());
			if (upload) {
				bean.setProfileurl(bean.getEmail() + "/" + file.getOriginalFilename());
				dao.insertUser(bean);
			} else {
				System.out.println("failed");
			}
			return "SuccessFile";
		}
	}

	@GetMapping("/loginuserfile")
	public String loginUser() {
		return "FileDBLogin";
	}

	@PostMapping("/loginuserfileDB")
	public String loginUserData(@RequestParam("login_email") String email,
			@RequestParam("login_password") String password, Model model) {
		System.out.println(email + " " + password);
		List<UserFileBean> users = dao.getUser(email, password);
		model.addAttribute("userinfo", users);
		return "UserFileDBInfo";
	}

	@GetMapping("/defaultpicdb")
	public String viewimage(@RequestParam("image") String str, Model model) {
		System.out.println(str);
		List<UserFileBean> users = dao.updatePic(str);
		model.addAttribute("userinfo", users);
		return "UserFileDBInfo";
	}

}
