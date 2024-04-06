/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.model.Student;
import com.ironhack.ironlibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired private StudentRepository studentRepository;


    public Optional<Student> findStudentByUsn(String usn) {
        return studentRepository.findStudentByUsn(usn);
    }
}
