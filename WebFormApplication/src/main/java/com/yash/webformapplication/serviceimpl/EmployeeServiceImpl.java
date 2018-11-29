/**
 * 
 */
package com.yash.webformapplication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.webformapplication.dao.EmployeeDao;
import com.yash.webformapplication.model.Employee;
import com.yash.webformapplication.service.EmployeeService;

/**
 * @author akshay.giradkar
 *
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> viewEmployeeDetails() {

		return employeeDao.viewEmployeeList();
	}

	public void addEmployee(Employee employee) {

		employeeDao.registerEmployee(employee);

	}

	public int deleteEmployee(Integer id) {

		return employeeDao.deleteEmployee(id);
	}

	public Employee getEmployee(int id) {

		return employeeDao.getEmployee(id);
	}

	public Employee updateEmployee(Employee employee) {

		return employeeDao.updateEmployee(employee);
	}

}
