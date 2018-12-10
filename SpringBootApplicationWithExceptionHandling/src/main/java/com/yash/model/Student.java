/**
 * 
 */
package com.yash.model;

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
@Table(name = "exceptiondemo")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -772706544763042013L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studId;

	@Column(name = "studName")
	private String studName;

	@Column(name = "studAddress")
	private String studAddress;

	@Column(name = "studCollege")
	private String studCollege;

	/**
	 * @param studId
	 * @param studName
	 * @param studAddress
	 * @param studCollege
	 */
	public Student(int studId, String studName, String studAddress, String studCollege) {

		this.studId = studId;
		this.studName = studName;
		this.studAddress = studAddress;
		this.studCollege = studCollege;
	}

	/**
	 * 
	 */
	public Student() {

		System.out.println("-----------Default Constructor--------------");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress
				+ ", studCollege=" + studCollege + "]";
	}

	/**
	 * @return the studId
	 */
	public int getStudId() {
		return studId;
	}

	/**
	 * @param studId the studId to set
	 */
	public void setStudId(int studId) {
		this.studId = studId;
	}

	/**
	 * @return the studName
	 */
	public String getStudName() {
		return studName;
	}

	/**
	 * @param studName the studName to set
	 */
	public void setStudName(String studName) {
		this.studName = studName;
	}

	/**
	 * @return the studAddress
	 */
	public String getStudAddress() {
		return studAddress;
	}

	/**
	 * @param studAddress the studAddress to set
	 */
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}

	/**
	 * @return the studCollege
	 */
	public String getStudCollege() {
		return studCollege;
	}

	/**
	 * @param studCollege the studCollege to set
	 */
	public void setStudCollege(String studCollege) {
		this.studCollege = studCollege;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((studAddress == null) ? 0 : studAddress.hashCode());
		result = prime * result + ((studCollege == null) ? 0 : studCollege.hashCode());
		result = prime * result + studId;
		result = prime * result + ((studName == null) ? 0 : studName.hashCode());
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
		Student other = (Student) obj;
		if (studAddress == null) {
			if (other.studAddress != null)
				return false;
		} else if (!studAddress.equals(other.studAddress))
			return false;
		if (studCollege == null) {
			if (other.studCollege != null)
				return false;
		} else if (!studCollege.equals(other.studCollege))
			return false;
		if (studId != other.studId)
			return false;
		if (studName == null) {
			if (other.studName != null)
				return false;
		} else if (!studName.equals(other.studName))
			return false;
		return true;
	}

}
