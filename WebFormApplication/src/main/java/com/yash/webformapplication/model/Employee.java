/**
 * 
 */
package com.yash.webformapplication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author akshay.giradkar
 *
 */

@Entity
@Table(name = "employeeinfo")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "ctc")
	private double ctc;

	@Column(name = "skill")
	private String skill;

	@Column(name = "domain")
	private String domain;

	@Column(name = "location")
	private String location;

	/**
	 * @return the id which is autoincremented
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name of an employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ctc of a employee
	 */
	public double getCtc() {
		return ctc;
	}

	/**
	 * @param ctc the ctc to set
	 */
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	/**
	 * @return the skill of the employee
	 */
	public String getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}

	/**
	 * @return the domain of the employee
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @return the location where the employee currently based on
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param ctc
	 * @param skill
	 * @param domain
	 * @param location
	 */
	public Employee(int id, String name, double ctc, String skill, String domain, String location) {
		super();
		this.id = id;
		this.name = name;
		this.ctc = ctc;
		this.skill = skill;
		this.domain = domain;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", ctc=" + ctc + ", skill=" + skill + ", domain=" + domain
				+ ", location=" + location + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ctc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(ctc) != Double.doubleToLongBits(other.ctc))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

}
