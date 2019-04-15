package com.foxminded.university.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foxminded.university.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    
    List<Student> findAll();
}
