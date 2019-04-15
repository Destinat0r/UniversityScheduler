package com.foxminded.university.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foxminded.university.model.Group;
import com.foxminded.university.model.Student;
import com.foxminded.university.service.impl.GroupService;
import com.foxminded.university.service.impl.StudentService;

@Controller
public class StudentController {
    
    private StudentService studentService;
    private GroupService groupService;
    
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/student")
    public String showStudent(@RequestParam("id") int id, Model model) {
        
        Student student = studentService.findById(id);
        Group group = student.getGroup();
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        
        model.addAttribute("group", group);
        model.addAttribute("student", student);
        
        return "/students/student";
    }
    
    @GetMapping("/students")
    public String allStudents(Model model) {
        
        List<Student> students = studentService.findAll();
        List<Group> groups = groupService.findAll();
        
        Student student = new Student();
        Group group = new Group();
        
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        
        return "/students/all_students";
    }
}
