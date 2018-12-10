/**
 * 
 */
package com.yash.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Student;

/**
 * @author akshay.giradkar
 *
 */


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
