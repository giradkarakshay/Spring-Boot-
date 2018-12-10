/**
 * 
 */
package com.yash.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Student;
import com.yash.service.StudentServiceImpl;

/**
 * @author akshay.giradkar
 *
 */

@RestController
@Transactional
@RequestMapping(value = { "/user" })
public class StudentController {

	@Autowired
	StudentServiceImpl service;

	@PostMapping(value = "/createUser")
	public ResponseEntity<Student> createUser(@RequestBody Student student) {

		try {
			service.createStudent(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(student, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/findUser/{id}")
	public Student findStudentById(@PathVariable int id) {
		return service.findStudentById(id);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		try {
			service.deleteStudentById(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		try {
			
			service.updateStudent(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

	}

}
