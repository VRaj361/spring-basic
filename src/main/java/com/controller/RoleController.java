package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.bean.RoleBean;
import com.dao.RoleDao;


@Controller	
public class RoleController {
	@Autowired
	RoleDao dao;
	@GetMapping("/newrole")
	public String newRole(Model model) {
		model.addAttribute("role",new RoleBean());
		return "NewRole";
	}
	@PostMapping("/saverole")
	public String saveRole(@ModelAttribute("role") @Valid RoleBean bean,BindingResult resu,Model model)
	{
		System.out.println(bean.getRolename());
		model.addAttribute("role",bean);
		if(resu.hasErrors()) {
			System.out.println("error");
			return "NewRole";
		}else {
			dao.insertRole(bean);
			return "Login";
		}
	}
	@GetMapping("/listrole")
	public String listroles(Model model) {
		List<RoleBean> role=dao.getAllRole();
		model.addAttribute("role",role);
		return "ListRole";
	}
	@RequestMapping(value = "/deleterole", method = RequestMethod.GET)
	public String deleteRole(@RequestParam int userid, Model model) {
		System.out.println(userid);
		dao.deleterole(userid);
		List<RoleBean> role=dao.getAllRole();
		model.addAttribute("role",role);
		return "ListRole";
	}
	@GetMapping("/viewrole")
	public String viewRole(@RequestParam("roleid") int roleid,Model model) {
		RoleBean role=dao.getRoleByRoleid(roleid);
		model.addAttribute("role",role);
		return "ViewRole";
	}
	
	@GetMapping("/updaterole")
	public String updateRole(@RequestParam("roleid") int roleid,Model model) {
		RoleBean role=dao.getRoleByRoleid(roleid);
		model.addAttribute("role",role);
		return "UpdateRole";
	}
	
	@PostMapping("/updateroledata")
	public String updateRoleData(@ModelAttribute("role") @Valid RoleBean bean,BindingResult resu,Model model) {
		System.out.println(bean.getRolename());
		model.addAttribute("role",bean);
		if(resu.hasErrors()) {
			System.out.println("error");
			return "NewRole";
		}else {
			dao.updateRole(bean);
			System.out.println("in");
			List<RoleBean> role=dao.getAllRole();
			model.addAttribute("role",role);
			return "ListRole";
		}
	}
	@PostMapping("/searchrole")
	public String searchRole(@RequestParam("searchname") String rolename,Model model)
	{
		System.out.println("Role name "+rolename );
		
		List<RoleBean> role=dao.searchRole(rolename);
		model.addAttribute("role",role);
		return "ListRole";
		
	}
	
	
	
	
}
