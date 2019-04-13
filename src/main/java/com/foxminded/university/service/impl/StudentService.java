package com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.DaoException;

import com.foxminded.university.dao.StudentRepository;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.EntityService;

@Service
public class StudentService implements EntityService<Student> {

    private StudentRepository studentRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student findById(int id) {

        Optional<Student> result = studentRepository.findById(id);
        
        Student student = null;
        
        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new DaoException("Nothing found by id " + id);
        }
        
        return student;
    }

    @Override
    public Student update(Student t) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<Student> findAll() {
        
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        
    }
}
