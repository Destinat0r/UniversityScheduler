package com.foxminded.university.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foxminded.university.model.Group;
import com.foxminded.university.model.Student;
import com.foxminded.university.service.impl.GroupService;
import com.foxminded.university.service.impl.StudentService;

@Controller
public class GroupController {

    private StudentService studentService;
    private GroupService groupService;
    
    public GroupController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    
    @PostMapping("/groups")
    public String createGroup(@ModelAttribute("group") Group group) {
        groupService.create(group);
        return "redirect:/groups";
    }
    
    @GetMapping("/groups")
    public String findAllGroups(Model model) {
        List<Group> groups = groupService.findAll();
        
        Group group = new Group();
        
        model.addAttribute("groups", groups);
        model.addAttribute("group", group);
        
        return "/groups/all_groups";
    }
    
    @GetMapping("/group")
    public String showGroup(@RequestParam("id") int id, Model model) {
        
        Group group = groupService.findById(id);
        List<Student> students = studentService.findAllByGroupId(id);

        model.addAttribute("group", group);
        model.addAttribute("students", students);
        
        return "/groups/group";
    }
    
    @PostMapping("/group/delete")
    public String delete(@ModelAttribute("id") int id) {
        groupService.deleteById(id);
        return "redirect:/groups";
    }
}
