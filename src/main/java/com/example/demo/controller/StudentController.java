package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
  private final StudentRepository studentRepo;

  public StudentController(StudentRepository studentRepo) {
    this.studentRepo = studentRepo;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("students", studentRepo.findAll());
    return "index";
  }

  @PostMapping("/add")
  public String addStudent(@RequestParam String name) {
    Student s = new Student();
    s.setName(name);
    studentRepo.save(s);
    return "redirect:/";
  }
}