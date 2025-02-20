package com.security.controller;

import com.security.entity.Student;
import com.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        Student student1 = studentService.saveStudent(student);
        return student1;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudent(){
        List<Student> all = studentService.findAll();
        return all;
    }

    @GetMapping("/findById/{id}")
    public Student findById(@RequestParam int id){
        Student byId1 = studentService.findById(id);
        return byId1;
    }
}
