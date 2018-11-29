/**
 * 
 */
package com.yash.webformapplication.dao;

import java.util.List;

import com.yash.webformapplication.model.Employee;

/**
 * @author akshay.giradkar
 *
 */
public interface EmployeeDao {

	List<Employee> viewEmployeeList();

	public void registerEmployee(Employee employee);

	public int deleteEmployee(Integer id);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(Integer id);

}
