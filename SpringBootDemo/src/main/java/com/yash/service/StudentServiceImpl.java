/**
 * 
 */
package com.yash.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Student;
import com.yash.repositories.StudentRepository;

/**
 * @author akshay.giradkar
 *
 */
@Service
@Transactional
public class StudentServiceImpl {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student findStudentById(int id) {

		return studentRepository.findById(id).get();
	}

	public void deleteStudentById(int id) {

		studentRepository.deleteById(id);
	}

	public void updateStudent(Student student) {
		Student student1 = findStudentById(student.getStudentId());
		student1.setCollegeName(student.getCollegeName());
		student1.setStudentAddress(student.getStudentAddress());
		student1.setStudentName(student.getStudentName());

		createStudent(student1);

	}

}
