/* (C)2024 */
package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {}
