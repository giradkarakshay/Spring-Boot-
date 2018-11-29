package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yash.model.Employee;
import com.yash.model.Skill;
import com.yash.model.WorkExperience;
import com.yash.service.ManagerService;

@Controller
@Scope("session")
@SessionAttributes("userId")
@RequestMapping(value="/user")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping(value="/managerProfile.ds")
	public String showManagerProfilePage() {
		return "managerProfile";
	}
	
	@GetMapping(value="/showEmployeeList.ds")
	public String showEmployeeListPage(Model model) {
		
		List<Employee> employeeList = managerService.getAllEmployee();
		if(employeeList.isEmpty()) {
			model.addAttribute("msg", "there is no employee available");
			return "employeeList";
		}
		else {
			model.addAttribute("employeeList", employeeList);
			return "employeeList";
		}
	}
	
	@GetMapping(value="/employeeProfile/{userId}.ds")
	public String showEmployeeProfilePage(@PathVariable int userId, Model model) {
		Employee employee = managerService.getEmployeeById(userId);
		List<WorkExperience> experienceList = managerService.getExperienceListById(userId);
		List<Skill> skillList = managerService.getSkillListById(userId);
		
		model.addAttribute("employee", employee);
		model.addAttribute("experienceList", experienceList);
		model.addAttribute("skillList", skillList);
		
		return "employeeProfile";
	}

}
