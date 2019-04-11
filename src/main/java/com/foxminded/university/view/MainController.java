package com.foxminded.university.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foxminded.university.dao.StudentRepository;
import com.foxminded.university.domain.Student;

@Controller
public class MainController {
    
    private StudentRepository studentRepository;
    
    public MainController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/students")
    public String allStudents(Model model) {
        
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        
        return "/students/all_students";
    }
    
}
