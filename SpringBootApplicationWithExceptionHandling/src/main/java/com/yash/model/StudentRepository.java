/**
 * 
 */
package com.yash.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author akshay.giradkar
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}