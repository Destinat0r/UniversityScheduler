package com.foxminded.university.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foxminded.university.domain.Group;
import com.foxminded.university.domain.Student;
import com.foxminded.university.service.impl.GroupService;
import com.foxminded.university.service.impl.StudentService;

@Controller
public class MainController {
    
    private StudentService studentService;
    private GroupService groupService;
    
    public MainController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/students")
    public String allStudents(Model model) {
        
        List<Student> students = studentService.findAll();
        List<Group> groups = groupService.findAll();
        
        System.out.println(groups);
        
        Student student = new Student();
        Group group = new Group();
        
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        
        return "/students/all_students";
    }
    
    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student) {
        
        studentService.create(student);
        return "redirect:/students";
    }
    
}
