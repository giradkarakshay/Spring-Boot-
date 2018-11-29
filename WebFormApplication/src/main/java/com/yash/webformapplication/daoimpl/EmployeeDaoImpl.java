/**
 * 
 */
package com.yash.webformapplication.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.webformapplication.dao.EmployeeDao;
import com.yash.webformapplication.model.Employee;

/**
 * @author akshay.giradkar
 *
 */

@Repository("employeedao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	@Override
	public List<Employee> viewEmployeeList() {

		return hibernateTemplate.loadAll(Employee.class);
	}

	@Transactional
	@Override
	public void registerEmployee(Employee employee) {
		System.out.println("aya "+ employee);
		hibernateTemplate.save(employee);
		System.out.println("gaya");

	}

	@Transactional
	@Override
	public int deleteEmployee(Integer id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			Employee employee1 = session.get(Employee.class, id);
			session.delete(employee1);
			System.out.println("deleted...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
			return 1;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		return 1;
	}

	@Transactional
	@Override
	public Employee updateEmployee(Employee employee) {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		try {
			session.getTransaction().begin();

			Employee emp = getEmployee(employee.getId());
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setCtc(employee.getCtc());
			emp.setSkill(employee.getSkill());
			emp.setDomain(employee.getDomain());
			emp.setLocation(employee.getLocation());
			session.update(emp);

			System.out.println("Updated...");
			session.getTransaction().commit();

			hibernateTemplate.flush();

			return employee;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		return employee;
	}

	
	@Transactional
	@Override
	public Employee getEmployee(Integer id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();

		Employee employeeToBeFound = new Employee();

		try {
			session.getTransaction().begin();

			employeeToBeFound = session.get(Employee.class, id);

		} catch (Exception e) {

			System.out.println("Exception Occured........." + e);
		}
		return employeeToBeFound;

	}
}
