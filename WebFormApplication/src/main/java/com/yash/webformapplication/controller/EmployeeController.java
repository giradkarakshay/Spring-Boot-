/**
 * 
 */
package com.yash.webformapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.webformapplication.model.Employee;
import com.yash.webformapplication.service.EmployeeService;

/**
 * @author akshay.giradkar
 *
 */

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/")
	public String showWelcomePage() {
		return "homePage";
	}

	@GetMapping(value = "/registerEmployee")
	public String showRegistrationPage() {
		return "registrationForm";
	}

	@GetMapping(value = "/viewEmployee")
	public String showEmployeeRecords() {
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees = employeeService.viewEmployeeDetails();
		System.out.println(listOfEmployees);
		ModelAndView mav = new ModelAndView("records");
		mav.addObject("listOfEmployees", listOfEmployees);
		return "listOfRecords";
	}

	@PostMapping(value = "/addEmployee")
	public String addEmployees(@ModelAttribute Employee employee) {

		employeeService.addEmployee(employee);
		return "homePage";

	}

	@DeleteMapping
	@RequestMapping(value = "/deleteEmployeeById")
	public String deleteEmployee(@RequestParam("id") int id) {

		employeeService.deleteEmployee(id);
		return "deleteUser";
	}

	@PutMapping
	@RequestMapping(value = "/update/{id}.ds")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee result = employeeService.updateEmployee(employee);
		if (result.equals(null)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
