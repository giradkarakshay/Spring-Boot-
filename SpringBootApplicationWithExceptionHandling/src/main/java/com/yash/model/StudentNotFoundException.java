/**
 * 
 */
package com.yash.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author akshay.giradkar
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3698038435896585187L;

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
