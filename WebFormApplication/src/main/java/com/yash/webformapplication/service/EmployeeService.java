/**
 * 
 */
package com.yash.webformapplication.service;

import java.util.List;

import com.yash.webformapplication.model.Employee;

/**
 * @author akshay.giradkar
 *
 */
public interface EmployeeService {

	List<Employee> viewEmployeeDetails();

	public void addEmployee(Employee employee);

	public int deleteEmployee(Integer id);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int id);

}
