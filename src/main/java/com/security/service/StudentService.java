package com.security.service;

import com.security.entity.Student;
import com.security.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    public Student saveStudent(Student student){
        Student save = studentRepo.save(student);
        return save;
    }

    public List<Student> findAll(){
        List<Student> all = studentRepo.findAll();
        return all;
    }

    public Student findById(int id){
        Optional<Student> byId = studentRepo.findById(id);
        Student student = byId.get();
        return student;
    }


}
